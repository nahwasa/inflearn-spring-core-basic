package com.nahwasa.study.inflearnspringcorebasic.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    public Member(final Long id, final String name, final Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setGrade(final Grade grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }
}
