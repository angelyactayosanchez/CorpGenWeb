package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderProductsEntity extends BaseEntity {

    public OrderProductsEntity() {
        super();
        setTableName("orders_products");
    }

    public List<OrderProduct> findByCriteria(String criteria, ProductsEntity productsEntity, OrdersEntity ordersEntity, CategoriesEntity categoriesEntity, UsersEntity usersEntity, StatusEntity statusEntity){
        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<OrderProduct> ordersProducts=new ArrayList<>();

            while (rs.next()){
                ordersProducts.add(OrderProduct.from(rs,productsEntity,ordersEntity,categoriesEntity,usersEntity,statusEntity));
            return ordersProducts;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<OrderProduct> findAllOrdersProducts(ProductsEntity productsEntity, OrdersEntity ordersEntity, CategoriesEntity categoriesEntity, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria("",productsEntity,ordersEntity,categoriesEntity,usersEntity,statusEntity);
    }

    public OrderProduct findByIdOrdersProducts(int id,
                                               ProductsEntity productsEntity, OrdersEntity ordersEntity, CategoriesEntity categoriesEntity, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id=%d",id),productsEntity,ordersEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }

    public OrderProduct findByProductIdOrdersProducts(int productId,
                                                      ProductsEntity productsEntity, OrdersEntity ordersEntity, CategoriesEntity categoriesEntity, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format("where product_id=%d",productId),productsEntity,ordersEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }

    public OrderProduct findByOrdersIdOrdersProducts(int ordersId,
                                                     ProductsEntity productsEntity, OrdersEntity ordersEntity, CategoriesEntity categoriesEntity, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format("where orders_id=%d",ordersId),productsEntity,ordersEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }


    /**DML**/


    public boolean createOrderProducts(OrderProduct orderProduct){
        return executeUpdate(String.format("insert into '%s'(quantity,product_id,product_price,orders_id)" +
                " values(%d,%d,%d,%d)",getTableName(), orderProduct.getQuantity(), orderProduct.getProduct().getId(), orderProduct.getPrice(), orderProduct.getOrder().getId()));
    }

    public boolean deleteOrderProducts(OrderProduct orderProduct){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), orderProduct.getId()));
    }

    public boolean updateQuantityOrderProducts(OrderProduct orderProduct){
        return executeUpdate(String.format("update'%s' set quantity=%d where id=%d",getTableName(), orderProduct.getQuantity(), orderProduct.getId()));
    }

}
