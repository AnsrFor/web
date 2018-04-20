package com.z2k.j2ee02;

public class Todo {
    private Integer id;
    private String content;

    public Todo(){}

    public Todo(Integer id, String content){
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
