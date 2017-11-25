package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {
    public UsersEntity() {
        super();
        setTableName("users");
    }

    public List<User> findByCriteria(String criteria, StatusEntity statusEntity){
        try {
            ResultSet rs=getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
           List<User> users=new ArrayList<>();
            while (rs.next()){
                users.add(User.from2(rs,statusEntity));
                return users;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAllUsers(StatusEntity statusEntity){
        return findByCriteria("",statusEntity);
    }

    public User findByIdUser(User user, StatusEntity statusEntity){
        return findByCriteria(String.format(" where id = %d", user.getId()),statusEntity).get(0);
    }

    public User findByIdUser(int id, StatusEntity statusEntity){
        return findByCriteria(String.format("  where id = %d",id),statusEntity).get(0);
    }

    public User findByFirstName(String firstName, StatusEntity statusEntity){
        return findByCriteria(String.format("  where first_name = '%s'",firstName),statusEntity).get(0);
    }

    public User findByLastName(String lastName, StatusEntity statusEntity){
        return findByCriteria(String.format("  WHERE last_name = '%s'",lastName),statusEntity).get(0);
    }

    public User findByManagerId(int manager, StatusEntity statusEntity){
        return findByCriteria(String.format(" where  manager = %d",manager),statusEntity).get(0);
    }

    /**DML**/

    public  boolean createAdminUsers(User user){
        return executeUpdate(String.format("INSERT INTO  %s (firstName,lastName,password,gender,address,number_phone,email,status_id,created_at,created_by,updated_at,updated_by)" +
                        " values('%s','%s','%s','%s','%s','%s','%s',%d,'%s',%d,'%s',%d)",getTableName(),
                user.getFirstName(), user.getLastName(), user.getPassword(), user.getGender(), user.getAddress(),
                user.getNumber_phone(), user.getEmail(), user.getStatus().getId()));
    }

    public  boolean createAdminUsers2(User user){
        return executeUpdate(String.format("insert into %s (" +
                        "firstName,lastName,password,gender,address,number_phone,email,status_id,created_at,created_by,updated_at,updated_by)" +
                        " values('%s','%s','%s','%s','%s','%s','%s',%d,'%s',%d,'%s',%d)",
                user.getFirstName(), user.getLastName(), user.getPassword(), user.getGender(), user.getAddress(),
                user.getNumber_phone(), user.getEmail(), user.getManager()));
    }


    public boolean createNormalUsers(User user){
        return executeUpdate(String.format("INSERT INTO %s (id,first_name, last_name, password, gender, address, email, status_id) " +
                        "VALUES (%d,'%s','%s','%s','%s','%s','%s',%d)",getTableName(),getMaxId(getTableName())+1,user.getFirstName(), user.getLastName(), user.getPassword(), user.getGender(), user.getAddress(),
                 user.getEmail(), user.getStatus().getId()));
    }

    public boolean updateAttributesUser(User user){
            return executeUpdate(String.format("UPDATE %s SET first_name='%s',last_name='%s' ,password='%s',address='%s',number_phone='%s' WHERE id=%d",getTableName(),
                    user.getFirstName(), user.getLastName(),user.getPassword(),user.getAddress(), user.getNumber_phone(), user.getId()));

    }

    public boolean changeStatusUser(User user){
        return executeUpdate(String.format("UPDATE %s set status=%d where id=%d",getTableName(), user.getStatus().getId(), user.getId()));
    }

    public boolean changePermissionsUser(User user){
        return executeUpdate(String.format("update  %s set manager=%d where id=%d",getTableName(), user.getManager()));
    }


    public  boolean deleteUsers(User user){
        return executeUpdate(String.format("delete from %s where id=%d",getTableName(), user.getId()));
    }

    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    public boolean validate(String email ,
                            String password ){
        boolean located = false;
        try {
            conn = this.getConnection();
            st = conn.createStatement();
            rs=st.executeQuery("select * from" +
                    " users where email  = '"+email+"' and password = '"+password+"'");
            if (rs.next()){
                located=true;
            }
            this.closesConnection();

        }catch (Exception e){

        }
        return located;
    }



    public List<User> findIdByEmailAndPassword(String email, String password,StatusEntity statusEntity
    ) {

        String sql ="SELECT * FROM users where email='"+email+"' AND password='"+password+"'";

        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            List<User> users = new ArrayList<>();
            while(rs.next()) users.add
                    (User.from2(rs,statusEntity));
            return users;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User findByNameAndPass(String email,String password ,StatusEntity statusEntity) {
        return findIdByEmailAndPassword(email,password,statusEntity).get(0);
    }
}
