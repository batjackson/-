package com.pp.pojo;

public class Im {
    private Integer id;
    private String name;
    private String imfor;
    private String pict1;
    private String pict2;
    private String pict3;

    public Im() {
    }

    public Im(Integer id, String name, String imfor) {
        this.id = id;
        this.name = name;
        this.imfor = imfor;
    }

    public String getPict1() {
        return pict1;
    }

    public void setPict1(String pict1) {
        this.pict1 = pict1;
    }

    public String getPict2() {
        return pict2;
    }

    public void setPict2(String pict2) {
        this.pict2 = pict2;
    }

    public String getPict3() {
        return pict3;
    }

    public void setPict3(String pict3) {
        this.pict3 = pict3;
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
