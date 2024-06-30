package com.example.xtremepush.task.Model;

import lombok.*;

@Data
public class User {
    private Name name;
    private Dob dob;

    @Data
    public static class Name {
        private String first;
        private String last;
    }

    @Data
    public static class Dob {
        private String date;
        private int age;
    }
}
