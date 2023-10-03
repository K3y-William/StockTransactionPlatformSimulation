package dao.impl;

import dao.userStockDao;
import entity.Stock;
import util.DButil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static util.DButil.exeUpdate;

public class userUserStockDaoImpl implements userStockDao {

    @Override
    public List<Stock> selectAll(int id) {
        Connection conn = DButil.getConnection();
        List<Stock> stock_list = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        //query all the stock info based on user_id from property
        //then use stock_id query current_price from stock_price
        String sql =
                "select rs.stock_id,stock_num,current_price,buying_date from " +
                    "(select property.stock_id,stock_num,buying_date " +
                    "from property where user_id =" + id +") as rs " +
                 "outer join stock_price on rs.stock_id = stock_price.stock_id";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                //extract data from rs
                int s_id = rs.getInt(1);
                int num = rs.getInt(2);
                int price = rs.getInt(3);
                Timestamp date = rs.getTimestamp(4);

                //put the data into stock object
                Stock stock = new Stock(s_id,price,num,date);

                //add all the stock into stock_list
                stock_list.add(stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(pstm,conn,rs);
        }
        return stock_list;
    }

    @Override
    public Stock selectOne(int id, int stock_id) {
        Stock stock = new Stock();
        Connection conn = DButil.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        //query all the stock info based on user_id from property,
        //then based on stock_id query the target stock
        //finally use stock_id query current_price from stock_price,
        String sql =
                "select stock.stock_id,stock_num,current_price,buying_date from " +
                        "(select stock_id,stock_num,buying_date " +
                            "from property where user_id = " + id + " AND stock_id = " + stock_id + ") as stock " +
                "left outer join stock_price on stock.stock_id = stock_price.stock_id";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                //extract data from rs
                int s_id = rs.getInt(1);
                int num = rs.getInt(2);
                int price = rs.getInt(3);
                Timestamp date = rs.getTimestamp(4);

                //put the data into stock object
                stock.stockSetValue(s_id,price,num,date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(pstm,conn,rs);
        }
        return stock;
    }

    //insert one of stock with its owner user_id into property
    //when user buy one of the stock that he already owned, we need to instead call insert, but update
    @Override
    public int insert(int id, Stock stock) {
        Object obj[] = {id, stock.getStock_id(), stock.getStock_num(), stock.getDate()};
        String sql = "insert into property values (?,?,?,?)";
        return exeUpdate(sql,obj);
    }

    //update original stock data in property into the pass in stock's status
    //so when you have done one of the transaction, you need to calculate the final state of specific stock
    //and create a stock object and call this update function
    @Override
    public int update(int id, Stock stock) {
        Object obj[] = {stock.getStock_num(),stock.getDate(),id,stock.getStock_id()};
        String sql = "update property set stock_num = ?, buying_date = ? where user_id = ? and stock_id = ?";
        return exeUpdate(sql,obj);
    }

    @Override
    public int delete(int id, int stock_id) {
        Object obj[] = {id,stock_id};
        String sql = "delete from property where user_id = ? and stock_id = ?";
        return exeUpdate(sql,obj);
    }


}
