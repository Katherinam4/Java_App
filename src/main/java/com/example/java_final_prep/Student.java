package com.example.java_final_prep;

public class Student {
    String name;
    String subject;
    int mark;

    public <Int> Student(String name, String subject, int mark){
        this.name = name;
        this.subject = subject;
        this.mark = mark;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    @Override
    public String toString() {
        return name+" "+subject+" "+mark;
    }
}
