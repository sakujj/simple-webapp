BEGIN TRANSACTION;
CREATE TABLE "user" (
	id BIGSERIAL PRIMARY KEY,
	name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	age integer NULL
);

INSERT INTO "user"(name, email, age) VALUES('Andy', 'Worhall', 35);
INSERT INTO "user"(name, email, age) VALUES('Wasley', 'Birmigham', 25);
COMMIT;
