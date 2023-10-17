package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private int user_id;
    private List<Stock> stock_list = new ArrayList<>();
    private int money;

    public User(int user_id, List<Stock> stock_list, int money) {
        this.user_id = user_id;
        this.stock_list = stock_list;
        this.money = money;
    }

    public int getUser_id() {
        return user_id;
    }

    public List<Stock> getStock_list() {
        return stock_list;
    }

    public int getMoney() {
        return money;
    }


}
