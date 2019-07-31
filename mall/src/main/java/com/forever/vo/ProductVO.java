package com.forever.vo;

public class ProductVO {
    private String name;
    private String subtitle;
    private String type;
    private double price;
    private Integer stock;
    private String mainImg;
    private String detail;

    @Override
    public String toString() {
        return "ProductVO{" +
                "name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", mainImg='" + mainImg + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ProductVO() {
    }

    public ProductVO(String name, String subtitle, String type, double price, Integer stock, String mainImg, String detail) {
        this.name = name;
        this.subtitle = subtitle;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.mainImg = mainImg;
        this.detail = detail;
    }
}
