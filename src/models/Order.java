package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private int id;
    private String state;
    private String createdAt;
    private User createdBy;
    private String updatedAt;
    private User updatedBy;

    public Order(int id, String state, String createdAt, User createdBy, String updatedAt, User updatedBy) {
        this.id = id;
        this.state = state;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public Order() {
    }


    public static Order from(ResultSet rs, UsersEntity usersEntity, StatusEntity statusEntity){
        try {
            return new Order(
                    rs.getInt("id"),
                    rs.getString("state"),
                    rs.getString("created_at"),
                    usersEntity.findByIdUser(rs.getInt("created_by"),statusEntity),
                    rs.getString("updated_at"),
                    usersEntity.findByIdUser(rs.getInt("updated_by"),statusEntity));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return  this;
    }

    public String getState() {
        return state;
    }

    public Order setState(String state) {
        this.state = state;
        return  this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Order setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return  this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Order setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return  this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Order setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return  this;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public Order setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
        return  this;
    }
}
