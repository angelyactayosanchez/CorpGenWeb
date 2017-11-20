package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Inventory {
    private int id;
    private int current_stock;
    private int initial_stock;
    private int minimal_stock;

    public Inventory(int id, int current_stock, int initial_stock, int minimal_stock) {
        this.setId(id);
        this.setCurrent_stock(current_stock);
        this.setInitial_stock(initial_stock);
        this.setMinimal_stock(minimal_stock);

    }


    public Inventory() {
    }

    public int getId() {
        return id;
    }

    public Inventory setId(int id) {
        this.id = id;
        return this;
    }

    public int getCurrent_stock() {
        return current_stock;
    }

    public Inventory setCurrent_stock(int current_stock) {
        this.current_stock = current_stock;
        return this;
    }

    public int getInitial_stock() {
        return initial_stock;
    }

    public Inventory setInitial_stock(int initial_stock) {
        this.initial_stock = initial_stock;
        return this;
    }

    public int getMinimal_stock() {
        return minimal_stock;
    }

    public Inventory setMinimal_stock(int minimal_stock) {
        this.minimal_stock = minimal_stock;
        return this;
    }

    public static Inventory from(ResultSet rs){
        try {
            return new Inventory(
                    rs.getInt("id"),rs.getInt("current_stock"),
                    rs.getInt("initial_stock"), rs.getInt("minimal_stock"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
