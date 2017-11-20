package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesEntity extends BaseEntity {


    public CategoriesEntity() {
        super();
        setTableName("categories");
    }

    public List<Category> findByCriteria(String criteria){
        try {
            List<Category> categories =new ArrayList<>();
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement()
                    .concat(criteria));
            if(rs==null) return null;
            while (rs.next()){
                categories.add(Category.from(rs));
                return categories;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Category>findAllCategories(){
        return findByCriteria("");
    }

    public Category findById(int id){
        return findByCriteria(String.format(" where id=%d",id)).get(0);
    }


    public Category findByDescription(String description){
        return findByCriteria(String.format(" where description='%s'",description)).get(0);
    }
    public Category createCategories(Category category){
        return executeUpdate(String.format("insert into '%s'values (%d,'%s')"
                ,getTableName(),category.getId(), category.getDescription()))?category:null;
    }
    public Category createCategories(String description){
        return createCategories(getMaxId(getTableName())+1,description);
    }


    public Category createCategories(int id,String description){
        return createCategories(new Category(id,description));
    }


    public boolean deleteCategory(Category category){
        return executeUpdate(String.format("delete from '%s' where id=%d",getTableName(), category.getId()));
    }

    public boolean updateCategory(int id,String description){
        return executeUpdate(String.format("update %s where set description id=%d",getTableName(),description,id));
    }

}
