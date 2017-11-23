package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Business {
    private String ruc;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String type;

    public String getSocial() {
        return social;
    }

    public Business setSocial(String social) {
        this.social = social;
        return this;
    }

    private String social;

    public String getType() {
        return type;
    }

    public Business setType(String type) {
        this.type = type;
        return this;
    }



    public int getRank() {
        return rank;
    }

    public Business setRank(int rank) {
        this.rank = rank;
        return this;
    }

    private int rank;

    public Business(String ruc, String name, String address, String phone, String email,int rank,String type,String social) {
        this.ruc = ruc;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.rank=rank;
        this.type=type;
        this.social=social;
    }

    public Business() {
    }

    public String getRuc() {
        return ruc;
    }

    public Business setRuc(String ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getName() {
        return name;
    }

    public Business setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Business setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Business setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Business setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public static Business from(ResultSet rs){
        try {
            return new Business(rs.getString("ruc")
                    ,rs.getString("name"),rs.getString("address")
                    ,rs.getString("phone"),rs.getString("email"),
                    rs.getInt("rank"),rs.getString("type"),rs.getString("social"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
