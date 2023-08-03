package org.sakuuj.learn;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class UserDao {
    static Properties props = new Properties();

    static {
        try {
            Class.forName("org.postgresql.Driver");
            props.load(User.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    Connection conn;

    {
        try {
            conn = DriverManager.getConnection("""
                    %s//%s/%s?user=%s&password=%s"""
                    .formatted(
                    props.getProperty("db.urlStart"),
                    props.getProperty("db.host"),
                    props.getProperty("db.database"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String SELECT_ALL = "SELECT * FROM \"user\"";
    private static final String INSERT = """
            INSERT INTO
            "user"(name, email, age)
            VALUES(?, ?, ?)""";

    public List<User> selectAll() {
        try (PreparedStatement statement = conn.prepareStatement(SELECT_ALL)) {
            var resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Optional<Integer> age = Optional.of(resultSet.getInt("age"));
                long id = resultSet.getLong("id");
                User userToAdd = User.builder()
                        .name(name)
                        .email(email)
                        .age(age.orElse(null))
                        .id(id)
                        .build();
                users.add(userToAdd);
            }

            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long insert(User user) {
        String name = user.getName();
        String email = user.getEmail();
        Integer age = user.getAge();
        try (PreparedStatement statement
                     = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setObject(1, name);
            statement.setObject(2, email);
            if (age != null)
                statement.setObject(3, age);
            else
                statement.setNull(3, Types.NULL);

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            keys.next();
            long id = keys.getLong(1);

            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
