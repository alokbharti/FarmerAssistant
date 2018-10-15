package com.example.bhart.farmerassistant;

public class Product_detail {

    private String name;
    private String state;
    private String district;
    private String pincode;
    private String commodity;
    private String price;
    private String weight;
    private boolean sold;
    private String phone;

    public Product_detail() {
    }

    public String getPhone() {
        return phone;
    }

    public Product_detail(String name, String state, String district, String pincode, String commodity, String price, String weight, boolean sold, String phone) {
        this.name = name;
        this.state = state;
        this.district = district;
        this.pincode = pincode;
        this.commodity = commodity;
        this.price = price;
        this.weight = weight;
        this.sold=sold;
        this.phone=phone;

    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCommodity() {
        return commodity;
    }

    public String getPrice() {
        return price;
    }

    public String getWeight() {
        return weight;
    }

    public boolean isSold() {
        return sold;
    }
}
