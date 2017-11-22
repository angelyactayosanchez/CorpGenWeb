package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private int gender;
    private String address;
    private String number_phone;
    private String email;
    private Status status;
    private int createdBy;
    private int updatedBy;
    private String createdAt;
    private String updatedAt;

    private static int manager=1;

    public int getManager() {
        return manager;
    }

    public User setManager(int manager) {
        this.manager = manager;
        return this;
    }


    public User(){

    }

    public User(int id, String firstName, String lastName, String password, int gender, String address, String number_phone, String email, Status status, int createdBy, int updatedBy, String createdAt, String updatedAt, int manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.number_phone = number_phone;
        this.email = email;
        this.status = status;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(int id, String first_name, String last_name, String password, int gender, String number_phone, String email, Status status_id, String created_at, int created_by, String updated_by, int updatedBy, int manager) {
    }

    public int TestAdmin(){
            return getId()==getManager() ? getManager() : getId();
        }


    public static User from2(ResultSet rs, StatusEntity statusEntity){

        try {
            return (new User())
                    .setId(rs.getInt("id"))
                    .setFirstName(rs.getString("first_name"))
                    .setLastName(rs.getString("last_name"))
                    .setPassword(rs.getString("password"))
                    .setGender(rs.getInt("gender"))
                    .setAddress(rs.getString("address"))
                    .setNumber_phone(rs.getString("number_phone"))
                    .setEmail(rs.getString("email"))
                    .setStatus(statusEntity.findByIdStatus(rs.getInt("status_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public User setGender(int gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public User setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public User setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public User setCreatedBy(int createdBy) {
        createdBy=TestAdmin();
        this.createdBy = createdBy;
        return this;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public User setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public User setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}