package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventsEntity extends BaseEntity {

   public EventsEntity() {
        super();
        setTableName("events");
    }

    public List<Event> findByCriteria(String  criteria, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){

        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<Event> events =new ArrayList<>();
            while (rs.next()){
                events.add(Event.from(rs,locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity));

            }
            return events;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> findAllEvents(LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria("",locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity);
    }

    public Event findByIdPromotions(Event event, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where id=%d", event.getId()),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Event findByIdPromotions(int id, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where id=%d",id),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Event findByNamePromotions(Event event, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where name='%s'", event.getName()),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Event findByNamePromotions(String name, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where name='%s'",name),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Event findByStatusPromotions(String status, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where state='%s'",status),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }



    public Event findByLocationsIdPromotions(int locationId, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where locations_id=%d",locationId),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Event findByProductsIdPromotions(int productId, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where locations_id=%d",productId),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    /**DML**/

    public boolean createPromotions(Event event){
        return executeUpdate(String.format("insert into %s (name,state,time_start,time_finish,locations_id,products_id,image,description) " +
                "values('%s','%s','%s','%s',%d,%d,'%s','%s')",getTableName(), event.getName(), event.getState()
                        , event.getTimeStart(),  event.getTimeFinish(), event.getLocation().getId(), event.getProduct().getId(), event.getImg()));
    }

    public boolean updatePromotions(Event event){
        return executeUpdate(String.format("update %s set name='%s',state='%s',time_start='%s',time_finish='%s',locations_id=%d,products_id=%d ,image='%s' where id=%d)"
                ,getTableName(), event.getName(), event.getState(), event.getTimeStart(),
                event.getTimeFinish(), event.getLocation().getId(), event.getProduct().getId(), event.getImg(), event.getId()));
    }

    public boolean changeStatusPromotions(Event event){
        return executeUpdate(String.format("update %s set  state='%s' where id=%d)"
                ,getTableName(), event.getState(), event.getId()));
    }


    public boolean deletePromotion(Event event){
        return executeUpdate(String.format("delete from %s where id=%d",getTableName(), event.getId()));
    }

}

