package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Location {
    private int id;
    private int actualCapacity;
    private int maxCapacity;
    private String startTime;
    private String closeTime;

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    private String address;
    private Business business;
    private Inventory inventory;

    public Location() {
    }

    public Location(int id, int actualCapacity, int maxCapacity, String startTime, String closeTime, Business business, Inventory inventory, String address) {
        this.setId(id);
        this.setActualCapacity(actualCapacity);
        this.setMaxCapacity(maxCapacity);
        this.setStartTime(startTime);
        this.setCloseTime(closeTime);
        this.setBusiness(business);
        this.setInventory(inventory);
        this.setAddress(address);
    }

    public static Location from(ResultSet rs, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        try {
            return new Location(rs.getInt("id"),
                                rs.getInt("actual_capacity"),
                                rs.getInt("max_capacity"),
                                rs.getString("start_time"),
                                rs.getString("close_time"),
                                businessesEntity.findByRUC(rs.getString("business_ruc")),
                                inventoriesEntity.findById(rs.getInt("inventories_id")),
                                rs.getString("address"));

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

    public int getActualCapacity() {
        return actualCapacity;
    }

    public void setActualCapacity(int actualCapacity) {
        this.actualCapacity = actualCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
