package com.example.demo.progmatic.backend.GetRandomMember.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString @Getter
//@AllArgsConstructor
public class Member {
    @Getter
    private String name;
    @Getter
    private boolean presented;

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, boolean presented) {
        this.name = name;
        this.presented = presented;
    }

    /*private String name;
    private boolean presented;

    public Member() {
        String name;
        boolean presented;
    }*/
}
