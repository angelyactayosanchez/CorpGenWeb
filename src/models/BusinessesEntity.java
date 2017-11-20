package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessesEntity extends BaseEntity {
    public BusinessesEntity(){
        super();
        setTableName("business");
    }

    public BusinessesEntity(Connection connection, String tableName){
        super(connection,tableName);
    }

    public List<Business> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Business> businesses = new ArrayList<>();
            while(rs.next())
                businesses.add(Business.from(rs));

            return businesses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public List<Business> findAllBusiness(){
        return findByCriteria("");
    }

    public Business findByRUC(String ruc){
        return findByCriteria(String.format(" where ruc='%s'",ruc)).get(0);
    }
    public Business findByName(String name){
        return findByCriteria(String.format(" where name='%s'",name)).get(0);
    }

    public Business findByAddress(String address){
        return findByCriteria(String.format(" where address='%s'",address)).get(0);
    }

    public Business findByPhone(String phone){
        return  findByCriteria(String.format(" where phone='%s'",phone)).get(0);
    }

    public Business findByEmail(String email){
        return findByCriteria(String.format(" where email='%s'",email)).get(0);
    }

    /**DML**/
    /*
    public Business createBusiness(Business business){
        return executeUpdate(String.format("INSERT INTO %s(ruc,name,address,phone,email) VALUES('%s','%s','%s','%s','%s')"
                ,getTableName(),business.getRuc(),business.getName(),business.getAddress(),business.getPhone(),business.getEmail()))?business:null;
    }

    public Business createBusiness(String ruc, String name, String address, String phone, String email){
        return createBusiness(new Business(ruc,name,address,phone,email));}
    */
    public boolean createBusiness(Business business){
        return executeUpdate(String.format("INSERT INTO %s(ruc,name,address,phone,email) VALUES('%s','%s','%s','%s','%s')"
                ,getTableName(),business.getRuc(),business.getName(),business.getAddress(),business.getPhone(),business.getEmail()));
    }




    public boolean updateBusiness(Business business){
       return updateBusiness(business.getRuc(),business.getName(),business.getAddress(),business.getPhone(),business.getEmail());}

    public boolean updateBusiness(String ruc, String name, String address, String phone, String email){
        return executeUpdate(String.format("update %s set name='%s', address='%s',phone='%s',email='%s' where ruc='%s' ",
                getTableName(),name,address,phone,email,ruc));}

    public boolean deleteBusiness(String ruc){
        return executeUpdate(String.format("delete from %s where ruc='%s'",getTableName(),ruc));
    }

}
