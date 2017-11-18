package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Promotion {

    private int id;
    private String name;
    private String state;
    private String description;
    private String timeStart;
    private String timeFinish;
    private Location location;
    private Product product;

    public Promotion() {
    }

    public Promotion(int id, String name, String state, String description, String timeStart, String timeFinish, Location location, Product product) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.description = description;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.location = location;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public Promotion setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Promotion setName(String name) {
        this.name = name;
        return this;
    }

    public String getState() {
        return state;
    }

    public Promotion setState(String state) {
        this.state = state;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Promotion setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public Promotion setTimeStart(String timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public Promotion setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Promotion setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Promotion setProduct(Product product) {
        this.product = product;
        return this;
    }

    public static Promotion from(ResultSet rs, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        try {
            return new Promotion(
                        rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("state"),
                    rs.getString("description"),
                    rs.getString("time_start"),
                    rs.getString("time_finish"),
                    locationsEntity.findById(rs.getInt("locations_id"), businessesEntity,inventoriesEntity),
                    productsEntity.findById(rs.getInt("products_id"),categoriesEntity));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
