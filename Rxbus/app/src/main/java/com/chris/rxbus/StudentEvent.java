package com.chris.rxbus;

/**
 * Email: suoyiman@163.coom
 */

public class StudentEvent {
    private String id;
    private String name;

    public StudentEvent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
