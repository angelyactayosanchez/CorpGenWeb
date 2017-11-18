package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private int id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int score;
    private Category category;

    public Product(int id, String name, String brand, double price, String description, int score, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.score = score;
        this.category = category;
    }

    public Product() {
    }

    public static Product from(ResultSet rs, CategoriesEntity categoriesEntity){
        try {
            return new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("brand"),
                    rs.getDouble("price"),
                    rs.getString("description"),
                    rs.getInt("score"),
                    categoriesEntity.findById(rs.getInt("categories_id")));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
