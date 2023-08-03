package org.sakuuj.learn;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private long id;
    private String name;
    private String email;
    private Integer age;
}
