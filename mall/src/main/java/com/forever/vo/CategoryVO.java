package com.forever.vo;

public class CategoryVO {
    private Integer id;
    private String name;

    public CategoryVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
