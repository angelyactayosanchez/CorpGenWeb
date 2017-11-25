package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Event {

    private int id;
    private String name;
    private String state;
    private String timeStart;
    private String timeFinish;
    private Location location;
    private Product product;

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    private String description;

    public String getImg() {
        return img;
    }

    public Event setImg(String img) {
        this.img = img;
        return this;
    }

    private String img;

    public Event() {
    }

    public Event(int id, String name, String state, String timeStart, String timeFinish, Location location, Product product, String img, String description) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.location = location;
        this.product = product;
        this.img=img;
        this.description=description;
    }



    public int getId() {
        return id;
    }

    public Event setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getState() {
        return state;
    }

    public Event setState(String state) {
        this.state = state;
        return this;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public Event setTimeStart(String timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public String getTimeFinish() {
        return timeFinish;
    }

    public Event setTimeFinish(String timeFinish) {
        this.timeFinish = timeFinish;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Event setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public Event setProduct(Product product) {
        this.product = product;
        return this;
    }

    public static Event from(ResultSet rs, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        try {
            return new Event(
                        rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("state"),
                    rs.getString("time_start"),
                    rs.getString("time_finish"),
                    locationsEntity.findById(rs.getInt("locations_id"), businessesEntity,inventoriesEntity),
                    productsEntity.findById(rs.getInt("products_id"),
                            categoriesEntity),rs.getString("image"),
                    rs.getString("description"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
