package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvTransaccionEntity extends BaseEntity {


    public InvTransaccionEntity() {
        super();
        setTableName("inventories_transaccion");
    }


    public List<InventoriesTransaccion> findByCriteria(String criteria, UsersEntity usersEntity, StatusEntity statusEntity){
    try {
        ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
        List<InventoriesTransaccion> inventoriesTransaccions=new ArrayList<>();
        while (rs.next()){
            inventoriesTransaccions.add(InventoriesTransaccion.from(rs,usersEntity,statusEntity));
            return inventoriesTransaccions;
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return null;
    }

    public List<InventoriesTransaccion> findAllTransaccions(UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria("",usersEntity,statusEntity);
    }

    public InventoriesTransaccion findByIdTransaccion(InventoriesTransaccion inventoriesTransaccion, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id=%d",inventoriesTransaccion.getId()),usersEntity,statusEntity).get(0);
    }
    public InventoriesTransaccion findByIdTransaccion(int id, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id=%d",id),usersEntity,statusEntity).get(0);
    }

    public InventoriesTransaccion findByCreatorTransaccion(int creator, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format("created_by=%d",creator),usersEntity,statusEntity).get(0);
    }

    public InventoriesTransaccion findByUpdaterTransaccion(int updater, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format("updated_by=%d",updater),usersEntity,statusEntity).get(0);
    }

    public InventoriesTransaccion findByStatusTransaccion(String status, UsersEntity usersEntity, StatusEntity statusEntity){
        return findByCriteria(String.format("state='%s'",status),usersEntity,statusEntity).get(0);
    }

    /**DML**/

    public boolean createInvTransaccion(InventoriesTransaccion inventoriesTransaccion){
        return executeUpdate(String.format("insert into '%s' (state,created_at,created_by,updated_at,updated_by)" +
                " values('%s','%s',%d'%s',%d)",getTableName(),inventoriesTransaccion.getStatus(),inventoriesTransaccion.getCreatedAt()
                    ,inventoriesTransaccion.getCreatedBy().getId(),inventoriesTransaccion.getUpdatedAt(),inventoriesTransaccion.getUpdatedBy().getId()));
    }

    public boolean updateInvTransaccion(InventoriesTransaccion inventoriesTransaccion){
        return executeUpdate(String.format("update '%s' set state='%s',updated_at='%s', updated_by=%d where id=%d",getTableName()
                ,inventoriesTransaccion.getStatus(),inventoriesTransaccion.getUpdatedAt(),inventoriesTransaccion.getUpdatedBy().getId(),inventoriesTransaccion.getId()));
    }


    public boolean deleteInvTransaccion(InventoriesTransaccion inventoriesTransaccion){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(),inventoriesTransaccion.getId()));
    }



}





