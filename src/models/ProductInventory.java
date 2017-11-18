package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductInventory {
    private int id;
    private Inventory inventory;
    private Product product;
    private int quantity;

    public ProductInventory(int id, Inventory inventory, Product product, int quantity) {
        this.id = id;
        this.inventory = inventory;
        this.product = product;
        this.quantity = quantity;
    }


    public static ProductInventory from(ResultSet rs, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        try {
            return new ProductInventory(
                    rs.getInt("id"),
                    inventoriesEntity.findById(rs.getInt("inventories_id")),
                    productsEntity.findById(rs.getInt("products_id"),categoriesEntity),
                    rs.getInt("quantity"));
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
