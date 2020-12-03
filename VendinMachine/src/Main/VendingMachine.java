package Main;

import entity.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VendingMachine {

   Inventory<Product,Integer> itemInventory=new Inventory<>();
   Inventory<Coin,Integer>  cashInventory=new Inventory<>();
   Screen screen=new Screen();
   Dispenser dispenser=new Dispenser();
   long currentBalance;

    public VendingMachine()
    {
        initialize();
    }
    public long getCurrentBalance() {
        return currentBalance;
    }
    /*sets the current balance by counting all coins int the cash inventory
    */
    public void setCurrentBalance()
    {
        for(Map.Entry<Coin,Integer> entry:this.cashInventory.getInventory().entrySet())
        {
            this.currentBalance+=entry.getValue().intValue();
        }
    }

    /*This method will initialize once vendingMachine gets started
    * */
    public void initialize()
   {
       itemInventory.putInventory(new Coke(),5);
       itemInventory.putInventory(new Pepsi(),5);
       itemInventory.putInventory(new Lays(),5);
       cashInventory.putInventory(Coin.ONEROOPE,10);
       cashInventory.putInventory(Coin.FIVEROOPE,10);
       cashInventory.putInventory(Coin.TENROOPE,10);
       cashInventory.putInventory(Coin.FIFTYROOPE,10);
       setCurrentBalance();
       screen.ShowMenu();
   }

   /*This method will return the price of selected element
   *  */
   public Long selectItemGetPrice(Product product)
   {
       if(itemInventory.getInventory().containsKey(product))
       {
          return product.getProductPrice();
       }
       else
          screen.showMsg("product not found");

       return null;
   }

   /*This calculates the total sum of inserted coins
   * */
   public long InsertedCoinsValue(List<Coin> coins)
   {
       long coinsValue=0;
       Iterator itr=coins.iterator();
       while(itr.hasNext())
       {
           coinsValue+=((Coin)itr.next()).getCoinValue();
       }
       return coinsValue;
   }

   public boolean IsChangeAvailable(long value)
   {
       return true;
   }

   public List<Coin> removeCoinsFromCashInventory(long changedValue)
   {
       List<Coin> coins=new ArrayList<Coin>();
       while(changedValue!=0) {
           if (changedValue >= Coin.HUNDREDROOPE.getCoinValue()) {
               coins.add(Coin.HUNDREDROOPE);
               changedValue -= Coin.HUNDREDROOPE.getCoinValue();
               if (changedValue != 0) {
                   continue;
               }

           } else if (changedValue >= Coin.FIFTYROOPE.getCoinValue()) {
               coins.add(Coin.FIFTYROOPE);
               changedValue -= Coin.FIFTYROOPE.getCoinValue();
               if (changedValue != 0) {
                   continue;
               }

           } else if (changedValue >= Coin.TWENTYROOPE.getCoinValue()) {
               coins.add(Coin.TWENTYROOPE);
               changedValue -= Coin.TWENTYROOPE.getCoinValue();
               if (changedValue != 0) {
                   continue;
               }

           } else if (changedValue >= Coin.TENROOPE.getCoinValue()) {
               coins.add(Coin.TENROOPE);
               changedValue -= Coin.TENROOPE.getCoinValue();
               if (changedValue != 0) {
                   continue;
               }

           } else if (changedValue >= Coin.FIFTYROOPE.getCoinValue()) {
               coins.add(Coin.FIFTYROOPE);
               changedValue -= Coin.FIFTYROOPE.getCoinValue();
               if (changedValue != 0) {
                   continue;
               }

           } else if (changedValue >= Coin.ONEROOPE.getCoinValue()) {
               coins.add(Coin.FIFTYROOPE);
               changedValue -= Coin.FIFTYROOPE.getCoinValue();
               if (changedValue != 0) {
                   continue;
               }

           }
       }

       return coins;
   }

   /*This removes product from item inventory
   * */
   public void removeItemFromItemInventory(Product product)
   {
       Integer quantity=itemInventory.getInventory().get(product);
       if(quantity==1)
           itemInventory.getInventory().remove(product);
       else
           itemInventory.getInventory().put(product,quantity-1);
   }

   public void addCoinsToCashInventory(List<Coin> coins)
   {
       for(Coin coin:coins)
       {
           int quantity=cashInventory.getInventory().getOrDefault(coin,0);
           cashInventory.getInventory().put(coin,quantity+1);
       }
   }
    /*
    * */
   public void InsertedCoinGetProductAndChange(List<Coin> coins, Product product)
   {
      long coinsValue=InsertedCoinsValue(coins);
      if(coinsValue==product.getProductPrice())
      {
           if(IsChangeAvailable(product.getProductPrice()-coinsValue))
           {
                 addCoinsToCashInventory(coins);
                 List<Coin> changeCoins=removeCoinsFromCashInventory(product.getProductPrice()-coinsValue);
                 setCurrentBalance();
                 removeItemFromItemInventory(product);
                 dispenser.setBucket(product,changeCoins);
                 dispenser.dispense();

           }
           else
               screen.showMsg("sufficient change not available");
      }
      else
      {
          screen.showMsg("Insufficient amount..please enter required amount");
      }
   }

   public void noOfItemsAfterSelecting()
   {
       for(Map.Entry<Product,Integer> entry:itemInventory.getInventory().entrySet())
       {
           System.out.println("item  "+entry.getKey().getProductName()+"s left are "+entry.getValue());
       }
   }
}