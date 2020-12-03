package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Dispenser {

    private HashMap<Product, List<Coin>> bucket=new HashMap<>();

    public HashMap<Product, List<Coin>> getBucket() {
        return bucket;
    }

    public void setBucket(Product product,List<Coin> coins) {
         bucket.put(product,coins);
    }

    public void dispense()
    {
        Set<Product> s=bucket.keySet();
        for(Product product:s)
        System.out.println("please  collect item :"+product.getProductName());
    }
}
