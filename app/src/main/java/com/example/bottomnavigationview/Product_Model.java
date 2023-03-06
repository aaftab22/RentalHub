package com.example.bottomnavigationview;

public class Product_Model {

    private String Product_Name, Product_Rent, Product_City, P_image, Deposit, Product_Description, Fuel_Type, Sub_Category;

    public Product_Model() {
    }

    public Product_Model(String product_Name, String product_Rent, String product_City, String p_image, String deposite) {
        Product_Name = product_Name;
        Product_Rent = product_Rent;
        Product_City = product_City;
        P_image = p_image;
        Deposit = deposite;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getProduct_Rent() {
        return Product_Rent;
    }

    public void setProduct_Rent(String product_Rent) {
        Product_Rent = product_Rent;
    }

    public String getProduct_City() {
        return Product_City;
    }

    public void setProduct_City(String product_City) {
        Product_City = product_City;
    }

    public String getP_image() {
        return P_image;
    }

    public void setP_image(String p_image) {
        P_image = p_image;
    }

    public String getDeposit() {
        return Deposit;
    }

    public void setDeposit(String deposit) {
        Deposit = deposit;
    }

    public String getProduct_Description() {
        return Product_Description;
    }

    public void setProduct_Description(String product_Description) {
        Product_Description = product_Description;
    }

    public String getFuel_Type() {
        return Fuel_Type;
    }

    public void setFuel_Type(String fuel_Type) {
        Fuel_Type = fuel_Type;
    }

    public String getSub_Category() {
        return Sub_Category;
    }

    public void setSub_Category(String sub_Category) {
        Sub_Category = sub_Category;
    }
}