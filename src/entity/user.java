package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class user implements Serializable{
    private int id;
    private List<Stock> stock = new ArrayList<>();
    private int capital;

}
