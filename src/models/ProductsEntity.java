package  models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsEntity extends BaseEntity {

    public ProductsEntity() {
        super();
        setTableName("products");
    }

    public List<Product> findByCriteria(String criteria, CategoriesEntity categoriesEntity){

        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<Product> products=new ArrayList<>();
            while (rs.next()){
                products.add(Product.from(rs,categoriesEntity));

            }
            return products;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    public List<Product> findAllProducts(CategoriesEntity categoriesEntity){
        return findByCriteria("",categoriesEntity);
    }
/*
    public Product findByIdStatus(Product products,CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" id=%d ",products.getId()),categoriesEntity).get(0);
    }
*/
    public Product findById(int id, CategoriesEntity categoriesEntity)
    {
        return findByCriteria(String.format(" where id = %d ",id),categoriesEntity).get(0);
    }



    public Product findByName(Product product, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" where  name='%s'", product.getName()),categoriesEntity).get(0);
    }

    public Product findByName(String name, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format("  where name='%s'",name),categoriesEntity).get(0);
    }


    public Product findByBrand(Product product, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" where  brand ='%s", product.getBrand()),categoriesEntity).get(0);
    }

    public Product findByPrice(Product product, CategoriesEntity categoriesEntity){
        return findByCriteria(String.format(" where price=%d", product.getPrice()),categoriesEntity).get(0);
    }

    /**DML**/

    public boolean insertProduct(Product product){

        return executeUpdate(String.format("insert into '%s' (id,name,brand,price,description,score,categories_id,img)" +
                " values('%s','%s',%d,'%s',%d,%d,'%s')",
                getTableName(), product.getId(), product.getName(), product.getBrand(), product.getPrice()
                , product.getDescription(), product.getScore(), product.getCategory().getId()));
    }

    public boolean insertProduct(int id, String name, String brand, double price, String description,int score, Category category,String image){
        return insertProduct(new Product(getMaxId()+1,name,brand,price,description,score, category,image));
    }

    public  boolean changeProduct(Product product){
        return executeUpdate(String.format("update '%s' set name='%s', brand='%s', price=%d, description='%s',categories_id=%d" +
                        "where id=%d",
                getTableName(), product.getName(), product.getBrand(), product.getPrice()
                , product.getDescription(), product.getCategory().getId(), product.getId()));
    }

    public boolean changePriceProduct(Product product){
        return executeUpdate(String.format("update '%s' set  price=%d where id=%d",getTableName(), product.getPrice(), product.getId()));
    }

    public boolean changeScoreProduct(Product product){
        return executeUpdate(String.format("update '%s' set  score=%d where id=%d",getTableName(), product.getScore(), product.getId()));
    }


    private int getMaxId(){
        String sql; /* "select MAX(id) AS max_id FROM products"*/;
        sql=String.format("select MAX(id) as max_id from '%s'",getTableName());

        try {
            ResultSet rs = getConnection()
                    .createStatement().executeQuery(sql);
            return rs.next() ? rs.getInt("max_id") : 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public boolean deleteProduct(Product product){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), product.getId()));
    }

    /**Necesita probrarse**/
    public boolean deleteProduct(int id){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(),id));
    }

}
