package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProduct {
    private int id;
    private int quantity;
    private Product product;
    private double price;
    private Order order;

    public OrderProduct(int id, int quantity, Product product, double price, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.price = price;
        this.order = order;
    }

    public OrderProduct() {
    }

    public static OrderProduct from(ResultSet rs, ProductsEntity productsEntity, OrdersEntity ordersEntity, CategoriesEntity categoriesEntity, UsersEntity usersEntity, StatusEntity statusEntity){
        try {
            return new OrderProduct(
                    rs.getInt("id"),
                    rs.getInt("quantity"),
                    productsEntity.findById(rs.getInt("product_id"),categoriesEntity),
                    rs.getDouble("product_price"),
                    ordersEntity.findByIdOrder(rs.getInt("orders_id"),usersEntity,statusEntity));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public OrderProduct setId(int id) {
        this.id = id;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderProduct setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderProduct setProduct(Product product) {
        this.product = product;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public OrderProduct setPrice(double price) {
        this.price = price;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderProduct setOrder(Order order) {
        this.order = order;
        return this;
    }
}
