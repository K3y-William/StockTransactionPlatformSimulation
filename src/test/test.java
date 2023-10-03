package test;

import dao.impl.userUserStockDaoImpl;
import dao.userStockDao;
import entity.Stock;
import util.DButil;

import java.util.Date;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import static dao.login.logging;
import static dao.login.register;
import static util.DButil.exeUpdate;
import static util.DButil.getConnection;



public class test {
    private  static   userStockDao  userStockDao=new userUserStockDaoImpl();

    public static void main(String[] args) {
        Timestamp ts=new Timestamp(new Date().getTime());
        Stock stock = new Stock(1,100,500,ts);
        System.out.println(userStockDao.update(1,stock));
        //System.out.println(userStockDao.delete(1,1));


    }
}
