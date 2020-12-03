package entity;

import java.util.HashMap;

public class Inventory<T,T1> {

    HashMap<T,T1> inventory=new HashMap();

    public HashMap<T, T1> getInventory() {
        return inventory;
    }

    public void putInventory(T t,T1 t1) {
        this.inventory.put(t,t1);
    }
}
