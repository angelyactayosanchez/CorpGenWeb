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

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }
}
