package dao;

import entity.Stock;
import entity.User;

import java.util.List;

public interface transactionDao {

    //return all the transactions that is posted on the platform
    List<User> selectAll();


    //return the specific stock on the platform
    List<User> checkStock(int stock_id);


    //return all the posts that created by certain user
    List<Stock> checkUser(int user_id);


    //cancel specific transaction based on the user_id and stock_id
    int cancel (int user_id, int stock_id);


    //update transactions
    int update(User user, Stock stock);

}
