package com.darksun.rentalhub.DataClass;

public class categoryModel {

    private String Category_name, Category_Image_ID;

    public categoryModel() {

    }

    public categoryModel(String category_name, String category_Image_ID) {
        Category_name = category_name;
        Category_Image_ID = category_Image_ID;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }

    public String getCategory_Image_ID() {
        return Category_Image_ID;
    }

    public void setCategory_Image_ID(String category_Image_ID) {
        Category_Image_ID = category_Image_ID;
    }
}
