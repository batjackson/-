package com.pp.pojo;

public class Im {
    private Integer id;
    private String name;
    private String imfor;

    public Im() {
    }

    public Im(Integer id, String name, String imfor) {
        this.id = id;
        this.name = name;
        this.imfor = imfor;
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

    public String getImfor() {
        return imfor;
    }

    public void setImfor(String imfor) {
        this.imfor = imfor;
    }
}
