package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersEntity extends BaseEntity {

    public OrdersEntity() {
        super();
        setTableName("orders");
    }

    public List<Order> findByCriteria(String criteria, UsersEntity usersEntity, StatusEntity statusEntity){

        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<Order> orders=new ArrayList<>();
           while (rs.next()){
               orders.add(Order.from(rs,usersEntity,statusEntity));
               return orders;
           }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
    }

    public List<Order> findAllOrders(UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria("",usersEntity,statusEntity);
    }

    public Order findByIdOrder(Order order, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id=%d", order.getId()),usersEntity,statusEntity).get(0);
    }

    public Order findByIdOrder(int id, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id=%d",id),usersEntity,statusEntity).get(0);
    }
    public Order findByCreator(int id, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where created_by=%d",id),usersEntity,statusEntity).get(0);
    }

    public Order findByUpdater(int id, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where update_by=%d",id),usersEntity,statusEntity).get(0);
    }

    /**DML**/


    public Order createNewOrder(Order order){
        return executeUpdate(String.format("insert into %s (id,state,created_at,created_by,updated_at,updated_by" +
                ") values('%s','%s',%d,'%s',%d",getTableName(), order.getState(), order.getCreatedAt(), order.getCreatedBy().getId(),
                order.getUpdatedAt(), order.getUpdatedBy().getId()))?order:null;
    }

    public Order createNewOrder(String state, String createdAt, User createdBy, String updatedAt, User updatedBy){
        return createNewOrder(new Order(getMaxId(getTableName())+1,state,createdAt,createdBy,updatedAt,updatedBy));}

    public boolean undoOrder(int id,String state,String updatedAt,int updatedBy){
        return executeUpdate(String.format("update %s set state='%s',updated_at='%s',updated_by=%d where id=%d",getTableName()
        , state,updatedAt,updatedBy,id));
    }

    public boolean committedOrder(Order order){
        return executeUpdate(String.format("update %s set state='%s',updated_at='%s',updated_by=%d where id=%d",getTableName(), order.getState()
                , order.getUpdatedAt(), order.getUpdatedBy().getId(), order.getId()));
    }
}
