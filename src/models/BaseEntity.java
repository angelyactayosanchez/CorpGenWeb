package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseEntity {
    Connection connection;
    String tableName;


    public BaseEntity(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    public BaseEntity() {
    }

    public Connection getConnection() {
        return connection;
    }

    public BaseEntity setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    public Connection closesConnection(){
        connection= null;
        return  connection;
    }
    public String getTableName() {
        return tableName;
    }

    public BaseEntity setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getBaseStatement() {
        return " SELECT * FROM ".concat(tableName).concat(" ");
    }

    public boolean executeUpdate(String sql) {
        try {
            int result = getConnection()
                    .createStatement()
                    .executeUpdate(sql);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMaxId(String tableName){
        String sql =  "SELECT MAX(id) AS max_id FROM " + tableName;

        try {
            ResultSet set = getConnection()
                    .createStatement().executeQuery(sql);
            return set.next() ? set.getInt("max_id") : null ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
