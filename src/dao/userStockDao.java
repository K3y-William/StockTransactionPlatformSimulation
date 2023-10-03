package dao;

import entity.Stock;
import java.util.List;

public interface userStockDao {

    //return all the user's stock data, include stock_id, stock_num, and adding date
    List<Stock> selectAll(int user_id);

    //return single stock data
    Stock selectOne(int id, int stock_id);

    //insert single stock data
    int insert(int id, Stock stock);

    //update single stock data
    int update(int id, Stock stock);

    //delete one of stock
    int delete(int id, int stock_id);

}
