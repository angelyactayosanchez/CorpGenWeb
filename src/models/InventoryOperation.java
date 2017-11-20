package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryOperation {
    private int id;
    private int quantity;
    private int type;
    private Inventory inventory;
    private Product product;
    private InventoriesTransaccion inventoriesTransaccion;




    public InventoryOperation(int id, int quantity, int type, Inventory inventory, Product product, InventoriesTransaccion inventoriesTransaccion) {
        this.id = id;
        this.quantity = quantity;
        this.type = type;
        this.inventory = inventory;
        this.product = product;
        this.inventoriesTransaccion = inventoriesTransaccion;
    }

    public InventoryOperation() {
    }

    public int getId() {
        return id;
    }

    public InventoryOperation setId(int id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public InventoryOperation setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getType() {
        return type;
    }

    public InventoryOperation setType(int type) {
        this.type = type;
        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public InventoryOperation setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public InventoryOperation setProduct(Product product) {
        this.product = product;
        return this;
    }

    public InventoriesTransaccion getInventoriesTransaccion() {
        return inventoriesTransaccion;
    }

    public InventoryOperation setInventoriesTransaccion(InventoriesTransaccion inventoriesTransaccion) {
        this.inventoriesTransaccion = inventoriesTransaccion;
        return this;
    }

    public static InventoryOperation from(ResultSet rs, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
                                                , UsersEntity usersEntity, StatusEntity statusEntity){
        try {
            return new InventoryOperation(
                    rs.getInt("id"),
                    rs.getInt("quantity"),
                    rs.getInt("type"),
                    inventoriesEntity.findById(rs.getInt("inventories_id"))
                    ,productsEntity.findById(rs.getInt("products_id"),categoriesEntity),
                    invTransaccionEntity.findByIdTransaccion(rs.getInt("it_id"),usersEntity,statusEntity));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
