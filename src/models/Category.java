package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
    private int id;
    private String description;

    public Category(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }


    public static Category from(ResultSet rs){
        try {
            return new Category(rs.getInt("id"),rs.getString("description"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
