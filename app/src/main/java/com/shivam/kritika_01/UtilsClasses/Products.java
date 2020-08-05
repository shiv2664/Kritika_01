package com.shivam.kritika_01.UtilsClasses;

public class Products {


    private String CityName;
    private String ThumbnailUrl;
    private String Colour;
    private String Product_Name;
    private String Brand;
    private String ShopAddrs;
    private String Gender;
    private String Prize;
    private String Sizes;
    private String Category;
    private String Product;
    private String imageURL;
    private String imageURL2;
    private String imageURL3;
    private String imageURL4;
    private String UID;
    private String MyLat;
    private String MyLong;

    public Products() {
    }

    public Products(String cityName, String thumbnailUrl, String colour, String product_Name,
                    String brand, String shopAddrs, String gender, String prize, String sizes,
                    String category, String product, String imageURL, String imageURL2,
                    String imageURL3, String imageURL4, String UID, String myLat, String myLong)
    {
        CityName = cityName;
        ThumbnailUrl = thumbnailUrl;
        Colour = colour;
        Product_Name = product_Name;
        Brand = brand;
        ShopAddrs = shopAddrs;
        Gender = gender;
        Prize = prize;
        Sizes = sizes;
        Category = category;
        Product = product;
        this.imageURL = imageURL;
        this.imageURL2 = imageURL2;
        this.imageURL3 = imageURL3;
        this.imageURL4 = imageURL4;
        this.UID = UID;
        MyLat = myLat;
        MyLong = myLong;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getThumbnailUrl() {
        return ThumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        ThumbnailUrl = thumbnailUrl;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getShopAddrs() {
        return ShopAddrs;
    }

    public void setShopAddrs(String shopAddrs) {
        ShopAddrs = shopAddrs;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getSizes() {
        return Sizes;
    }

    public void setSizes(String sizes) {
        Sizes = sizes;
    }

    public String getPrize() {
        return Prize;
    }

    public void setPrize(String prize) {
        Prize = prize;
    }

    public String getImageURL() { return imageURL; }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL2() {
        return imageURL2;
    }

    public void setImageURL2(String imageURL2) {
        this.imageURL2 = imageURL2;
    }

    public String getImageURL3() {
        return imageURL3;
    }

    public void setImageURL3(String imageURL3) {
        this.imageURL3 = imageURL3;
    }

    public String getImageURL4() {
        return imageURL4;
    }

    public void setImageURL4(String imageURL4) {
        this.imageURL4 = imageURL4;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getMyLat() {
        return MyLat;
    }

    public void setMyLat(String myLat) {
        MyLat = myLat;
    }

    public String getMyLong() {
        return MyLong;
    }

    public void setMyLong(String myLong) {
        MyLong = myLong;
    }
}




