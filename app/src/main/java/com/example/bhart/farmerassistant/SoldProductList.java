package com.example.bhart.farmerassistant;

public class SoldProductList {
    private String name;
    private String state;
    private String district;
    private String pincode;
    private String commodity;
    private String price;
    private String weight;
    private String phone;
    private boolean sold;
    private String key;

    public SoldProductList(String name, String state, String district, String pincode, String commodity, String price, String weight,String phone, boolean sold, String key) {
        this.name = name;
        this.state = state;
        this.district = district;
        this.pincode = pincode;
        this.commodity = commodity;
        this.price = price;
        this.weight = weight;
        this.phone=phone;
        this.sold = sold;
        this.key = key;
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

    public String getPhone() {
        return phone;
    }

    public boolean isSold() {
        return sold;
    }

    public String getKey() {
        return key;
    }
}
