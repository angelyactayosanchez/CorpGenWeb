package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoriesTransaccion {
    private int id;
    private String status;
    private String createdAt;
    private User createdBy;
    private String updatedAt;
    private User updatedBy;

    public InventoriesTransaccion(int id, String status, String createdAt, User createdBy, String updatedAt, User updatedBy) {
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public InventoriesTransaccion() {
    }

    public int getId() {
        return id;
    }

    public  InventoriesTransaccion setId(int id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public  InventoriesTransaccion setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public InventoriesTransaccion setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public InventoriesTransaccion setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public  InventoriesTransaccion setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public InventoriesTransaccion setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public static InventoriesTransaccion from(ResultSet rs, UsersEntity usersEntity, StatusEntity statusEntity){
        try {
            return new InventoriesTransaccion(
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
}
