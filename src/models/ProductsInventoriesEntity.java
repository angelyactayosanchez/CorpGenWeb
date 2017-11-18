package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsInventoriesEntity  extends BaseEntity {

    public ProductsInventoriesEntity() {
        super();
        setTableName("products_inventories");
    }

    public List<ProductInventory> findByCriteria(String criteria, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){

        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<ProductInventory> productsInventories=new ArrayList<>();
            while (rs.next()){
                productsInventories.add(ProductInventory.from(rs,inventoriesEntity,productsEntity,categoriesEntity));
                return productsInventories;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<ProductInventory> findAllProductInInventories(InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        return findByCriteria("",inventoriesEntity,productsEntity,categoriesEntity);
    }

    public ProductInventory findByProductsInventoriesId(int id, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" where id=%d",id),inventoriesEntity,productsEntity,categoriesEntity).get(0);
    }

    public ProductInventory findByProductId(int productId, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" where products_id=%d",productId),inventoriesEntity,productsEntity,categoriesEntity).get(0);
    }

    public ProductInventory findByInventoriesId(int inventoryId, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" where inventories_id=%d",inventoryId),inventoriesEntity,productsEntity,categoriesEntity).get(0);
    }

    public List<ProductInventory> findByProductsInventary(int id_product, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        String sql="SELECT pi.inventories_id,pi.products_id,p.name,pi.quantity,sum(pi.quantity) as total_products " +
                "FROM products_inventories pi INNER JOIN inventories i " +
                "on i.id=pi.inventories_id INNER JOIN  products p" +
                " on p.id=pi.products_id WHERE pi.products_id=" +id_product +
                " GROUP BY pi.inventories_id";
        List<ProductInventory> productsInventories=new ArrayList<>();
        try {
            ResultSet rs=getConnection().createStatement().executeQuery(sql);
            if(rs==null){return null;}
            while (rs.next()){
                productsInventories.add(ProductInventory.from(rs,inventoriesEntity,productsEntity,categoriesEntity));
                return productsInventories;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productsInventories;
    }


    public List<ProductInventory> findByInventoryProducts(int id_inventories, InventoriesEntity inventoriesEntity, ProductsEntity productsEntity, CategoriesEntity categoriesEntity){
        String sql="SELECT pi.inventories_id,pi.products_id,p.name,pi.quantity,sum(pi.quantity) as total_products " +
                "FROM products_inventories pi INNER JOIN inventories i " +
                "on i.id=pi.inventories_id INNER JOIN  products p" +
                " on p.id=pi.products_id WHERE pi.products_id=" +id_inventories +
                " GROUP BY pi.inventories_id";
        List<ProductInventory> productsInventories=new ArrayList<>();
        try {
            ResultSet rs=getConnection().createStatement().executeQuery(sql);
            if(rs==null){return null;}
            while (rs.next()){
                productsInventories.add(ProductInventory.from(rs,inventoriesEntity,productsEntity,categoriesEntity));
                return productsInventories;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productsInventories;
    }



    public boolean createProductsInventories(ProductInventory productInventory){
        return executeUpdate(String.format("insert into '%s'(inventories_id,products_id,quantity)" +
                " values(%d,%d,%d)",getTableName(), productInventory.getInventory().getId(), productInventory.getProduct().getId()
                    , productInventory.getQuantity()));
    }



    public boolean updateCantity(ProductInventory productInventory){
        return executeUpdate(String.format("UPDATE '%s' SET quantity=%d WHERE inventories_id=%d AND products_id=%d",getTableName()
                                            , productInventory.getQuantity(), productInventory.getInventory().getId()
                                            , productInventory.getProduct().getId()));
    }

    public boolean deleteByIdPI(ProductInventory productInventory){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), productInventory.getId()));}


}
