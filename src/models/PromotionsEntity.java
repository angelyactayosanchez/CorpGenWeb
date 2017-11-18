package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotionsEntity extends BaseEntity {

   public PromotionsEntity() {
        super();
        setTableName("promotions");
    }

    public List<Promotion> findByCriteria(String  criteria, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){

        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<Promotion> promotions=new ArrayList<>();
            while (rs.next()){
                promotions.add(Promotion.from(rs,locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity));
                return promotions;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Promotion> findAllPromotions(LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria("",locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity);
    }

    public Promotion findByIdPromotions(Promotion promotion, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where id=%d", promotion.getId()),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Promotion findByIdPromotions(int id, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where id=%d",id),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Promotion findByNamePromotions(Promotion promotion, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where name='%s'", promotion.getName()),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Promotion findByNamePromotions(String name, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where name='%s'",name),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Promotion findByStatusPromotions(String status, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where state='%s'",status),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }



    public Promotion findByLocationsIdPromotions(int locationId, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where locations_id=%d",locationId),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    public Promotion findByProductsIdPromotions(int productId, LocationsEntity locationsEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity, BusinessesEntity businessesEntity, InventoriesEntity inventoriesEntity){
        return findByCriteria(String.format(" where locations_id=%d",productId),locationsEntity,productsEntity,categoriesEntity, businessesEntity,inventoriesEntity).get(0);
    }

    /**DML**/

    public boolean createPromotions(Promotion promotion){
        return executeUpdate(String.format("insert into '%s' (name,state,description,time_start,time_finish,locations_id,products_id) " +
                "values('%s','%s','%s','%s','%s',%d,%d)",getTableName(), promotion.getName(), promotion.getState(), promotion.getDescription(), promotion.getTimeStart(),
                            promotion.getTimeFinish(), promotion.getLocation().getId(), promotion.getProduct().getId()));
    }

    public boolean updatePromotions(Promotion promotion){
        return executeUpdate(String.format("update '%s' set name='%s',state='%s',description='%s',time_start='%s',time_finish='%s',locations_id=%d,products_id=%d where id=%d)"
                ,getTableName(), promotion.getName(), promotion.getState(), promotion.getDescription(), promotion.getTimeStart(),
                promotion.getTimeFinish(), promotion.getLocation().getId(), promotion.getProduct().getId(), promotion.getId()));
    }

    public boolean changeStatusPromotions(Promotion promotion){
        return executeUpdate(String.format("update '%s' set  state='%s' where id=%d)"
                ,getTableName(), promotion.getState(), promotion.getId()));
    }


    public boolean deletePromotion(Promotion promotion){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), promotion.getId()));
    }

}

