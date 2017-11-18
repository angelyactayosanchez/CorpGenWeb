package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Status {
    private int id;
    private String type;
    private String description;

    public Status(int id, String type, String description) {
        this.setId(id);
        this.setType(type);
        this.setDescription(description);
    }

    public Status() {
    }


    public static Status from(ResultSet rs){

        try {
            return new Status(rs.getInt("id"),
                    rs.getString("type"),
                    rs.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    public int getId() {
        return id;
    }

    public Status setId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public  Status setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Status setDescription(String description) {
        this.description = description;
        return this;
    }
}
