package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoriesEntity extends BaseEntity {

    public InventoriesEntity() {
        super();
        setTableName("inventories");
    }

    public List<Inventory> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Inventory> inventories = new ArrayList<>();
            while(rs.next())
                inventories.add(Inventory.from(rs));

            return inventories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Inventory> findAllInventories(){
        return findByCriteria("");
    }


    public Inventory findById(int id){
        return findByCriteria(String.format(" where id = %d",id)).get(0);
    }

    public Inventory findById(Inventory inventory){
        return findByCriteria(String.format(" where id=%d", inventory.getId())).get(0);
    }
/*
    public Inventory findByIdStatus(int id){

    }*/
    public Inventory findByLocationsId(int id){
        return findByCriteria(String.format(" where locations_id=%d",id)).get(0);
    }

    /**DML**/

    public boolean createNewInventory(Inventory inventory){
        return executeUpdate(String.format("insert into '%s' (initial_stock,minimal_stock) values(%d,%d)",getTableName(), inventory.getInitial_stock(), inventory.getMinimal_stock()));
    }
/*
    public boolean createNewInventory(int current_stock, int initial_stock, int minimal_stock){
        return createNewInventory(new Inventory(getMaxId(getTableName())+1,current_stock,initial_stock,minimal_stock));}
*/
    public boolean deleteInventory(Inventory inventory){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), inventory.getId()));
    }

    public boolean updateActualInventory(Inventory inventory){
        return executeUpdate(String.format("update '%s' set " +
                "current_stock=%d where id=%d",getTableName(), inventory.getCurrent_stock(), inventory.getId()));
    }

    public boolean updateInventory(Inventory inventory){
        return updateInventory(inventory.getId(), inventory.getCurrent_stock(), inventory.getInitial_stock(), inventory.getMinimal_stock());}


    public boolean updateInventory(int id,int currentStock,int initial_stock,int minimal_stock){
        return executeUpdate(String.format("update '%s' set " +
                "current_stock=%d,initial_stock=%d,minimal_stock=%d where id=%d",getTableName(),currentStock,initial_stock,minimal_stock,id));

    }

}

