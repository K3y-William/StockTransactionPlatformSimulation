package dao.impl;

import dao.transactionDao;
import entity.Stock;
import entity.User;

import java.util.List;

public class sellingDaoImp implements transactionDao {
    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public List<User> checkStock(int stock_id) {
        return null;
    }

    @Override
    public List<Stock> checkUser(int user_id) {
        return null;
    }

    @Override
    public int cancel(int user_id, int stock_id) {
        return 0;
    }

    @Override
    public int update(User user, Stock stock) {
        return 0;
    }
}
