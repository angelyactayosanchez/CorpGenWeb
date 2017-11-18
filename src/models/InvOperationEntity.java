package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvOperationEntity extends BaseEntity {



    public InvOperationEntity() {
        super();
        setTableName("inventories_operation");
    }

    public List<InventoryOperation> findByCriteria(String criteria, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
            , UsersEntity usersEntity, StatusEntity statusEntity){
        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<InventoryOperation> inventoryOperations =new ArrayList<>();
            while (rs.next()){
                inventoryOperations.add(InventoryOperation.from(rs,inventoriesEntity,productsEntity, invTransaccionEntity,categoriesEntity,usersEntity,statusEntity));
                return inventoryOperations;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<InventoryOperation> findAllInvOperations(InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
            , UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria("",inventoriesEntity,productsEntity, invTransaccionEntity,categoriesEntity,usersEntity,statusEntity);
    }

    public InventoryOperation findByInOperationId(int id, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
            , UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id=%d",id),inventoriesEntity,productsEntity, invTransaccionEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }

    public InventoryOperation findByInventoryIdIO(int id, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
            , UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where inventories_id=%d",id),inventoriesEntity,productsEntity, invTransaccionEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }

    public InventoryOperation findByProductsIdIO(int id, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
            , UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where products_id=%d",id),inventoriesEntity,productsEntity, invTransaccionEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }
    public InventoryOperation findByInventoryTransaccionIdIO(int id, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, InvTransaccionEntity invTransaccionEntity, CategoriesEntity categoriesEntity
            , UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where it_id=%d",id),inventoriesEntity,productsEntity, invTransaccionEntity,categoriesEntity,usersEntity,statusEntity).get(0);
    }

    /**DML**/

    public boolean createInvOp(InventoryOperation inventoryOperation){
        return executeUpdate(String.format("insert into '%s' (quantity,type,inventories_id,products_id,it_id)" +
                " values(%d,%d,%d,%d,%d)",getTableName(), inventoryOperation.getQuantity(), inventoryOperation.getType(),
                inventoryOperation.getInventory().getId(), inventoryOperation.getProduct().getId(), inventoryOperation.getInventoriesTransaccion().getId()));
    }
/*
    public boolean createInvOp(int id, int quantity, int type, Inventory inventories, Product products, InventoriesTransaccion inventoriesTransaccion){
        return createInvOp(new InventoryOperation(id,quantity,type, inventories, products,inventoriesTransaccion));
       }
*/
    public boolean updateInvOp(InventoryOperation inventoryOperation){
        return executeUpdate(String.format("update '%s' set quantity=%d,type=%d" +
                        " where id=%d",getTableName(), inventoryOperation.getQuantity(), inventoryOperation.getType()
                , inventoryOperation.getId()));
    }

    public boolean updateInvOp(int id,int type,int quantity){
        return executeUpdate(String.format("update '%s' set quantity=%d,type=%d" +
                        " where id=%d",getTableName(),quantity,type , id));
    }
    public boolean updateQuantityInvOp(InventoryOperation inventoryOperation){
        return executeUpdate(String.format("update '%s' set quantity=%d" +
                        " where id=%d",getTableName(), inventoryOperation.getQuantity(), inventoryOperation.getId()));
    }
}
