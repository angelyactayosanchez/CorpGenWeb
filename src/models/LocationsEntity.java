package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationsEntity extends BaseEntity {


    public LocationsEntity() {
        super();
        setTableName("locations");
    }

    public List<Location> findByCriteria(String criteria, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){

        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<Location> locations=new ArrayList<>();
            while (rs.next()){
                locations.add(Location.from(rs, businessesEntity,inventoriesEntity));
                return locations;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    return null;
    }

    public List<Location> findAllLocations(BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria("", businessesEntity,inventoriesEntity);
    }
    public List<Location> findLocationsByRuc(String ruc, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format("where ruc='%s'",ruc),businessesEntity,inventoriesEntity);
    }



    public Location findById(int id, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where id=%d",id), businessesEntity,inventoriesEntity).get(0);
    }
    public Location findByIdLocation(int id, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where id=%d",id), businessesEntity,inventoriesEntity).get(0);
    }


    public Location findByAddress(Location location, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where address='%s'", location.getAddress()), businessesEntity,inventoriesEntity).get(0);
    }

    public Location findByAddress(String address, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where address='%s'",address), businessesEntity,inventoriesEntity).get(0);
    }
/*
    public Location SeeCapacity(Location location){
      return findByCriteria(String.format(""))
    }
*/
    public String getMaxCapacity(Location location){
        return String.valueOf(String.format("select max_capacity from %s where id=%d", getTableName(), location.getId()));
    }

    /**DML**/

    public boolean createLocation(Location location){
        return executeUpdate(String.format("insert into %s (max_capacity,start_time,close_time,business_id,inventories_id,address) " +
                "values(%d,'%s','%s','%s',%d,'%s)",getTableName(), location.getMaxCapacity(), location.getStartTime(), location.getCloseTime(), location.getBusiness().getRuc(), location.getInventory().getId(), location.getAddress()));
    }

    public boolean updateActualCapacityLocations(Location location){

        return executeUpdate(String.format("update %s set actual_capacity=%d where id=%d",getTableName(), location.getActualCapacity(), location.getId()));
    }

    public boolean updateAddressLocations(Location location){

        return executeUpdate(String.format("update %s set address='%s' where id=%d",getTableName(), location.getAddress(), location.getId()));
    }

    public boolean updateMaxCapacity(Location location){
        return executeUpdate(String.format("update '%s' set max_capacity=%d where id=%d",getTableName(), location.getMaxCapacity(), location.getId()));
    }

    public boolean updateSchedulesLocations(Location location){
        return executeUpdate(String.format("update '%s' set start_time='%s' , close_time?'%s' where id=%d",getTableName(), location.getStartTime(), location.getCloseTime(), location.getId()));
    }

    public boolean updateLocations(Location location){
        return executeUpdate(String.format("update '%s' set actual_capacity=%d,max_capacity=%d,start_time='%s',close_time='%s',business_ruc='%s',inventories_id=%d,address='%s' " +
                " where id=%d",getTableName(), location.getActualCapacity(), location.getMaxCapacity(), location.getStartTime(), location.getCloseTime(), location.getBusiness().getRuc(), location.getInventory().getId(), location.getAddress(), location.getId()));
    }


    public boolean deleteLocation(Location location){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), location.getId()));
    }
}
