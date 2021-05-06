package com.pp.pojo;

public class Price {
    private Integer id;
    private String type;
    private double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Price() {
    }

    public Price(Integer id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }
}
