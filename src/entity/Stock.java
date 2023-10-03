package entity;

import java.io.Serializable;
import java.sql.Timestamp;

//stock entity, store stock_id, stock_num and related changing date
public class Stock implements Serializable {
    private int stock_id;
    private int stock_price;
    private int stock_num;
    private Timestamp date;

    public Stock(int id, int price, int num, Timestamp date){
        this.stock_id = id;
        this.stock_price = price;
        this.stock_num = num;
        this.date = date;
    }

    public Stock() {

    }


    public Stock stockSetValue(int id, int price, int num, Timestamp date){
        this.stock_id = id;
        this.stock_price = price;
        this.stock_num = num;
        this.date = date;
        return this;
    }

    public int getStock_id() {
        return stock_id;
    }

    public int getStock_price(){
        return stock_price;
    }

    public int getStock_num() {
        return stock_num;
    }

    public Timestamp getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "stock{" +
                "stock_id=" + stock_id +
                ", stock_num=" + stock_num +
                ", date=" + date +
                '}';
    }
}
