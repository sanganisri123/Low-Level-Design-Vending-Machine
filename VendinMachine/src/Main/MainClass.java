package Main;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String args[])
    {
        VendingMachine vm=new VendingMachine();
        Scanner scan=new Scanner(System.in);
       while(true) {
           int input = scan.nextInt();
           Product product = null;

           switch (input) {
               case 1:
                   product = new Coke();
                   break;
               case 2:
                   product = new Pepsi();
                   break;
               case 3:
                   product = new Lays();
                   break;
               default:
                   System.out.println("Selected invalid option");
           }

           vm.screen.showMsg("The price of each " + product.getProductName() + " is:" + vm.selectItemGetPrice(product).toString());


           vm.screen.showMsg("Insert valid coins");
           int[] coinsInp = new int[3];
           coinsInp[0] = scan.nextInt();
           coinsInp[1] = scan.nextInt();
           coinsInp[2] = scan.nextInt();

           List<Coin> coins = new ArrayList<>();

           for (int i = 0; i < 3; i++) {
               switch (coinsInp[i]) {
                   case 1:
                       coins.add(Coin.ONEROOPE);
                       break;
                   case 5:
                       coins.add(Coin.FIVEROOPE);
                       break;
                   case 10:
                       coins.add(Coin.TENROOPE);
                       break;
                   case 20:
                       coins.add(Coin.TWENTYROOPE);
                       break;
                   case 50:
                       coins.add(Coin.FIFTYROOPE);
                       break;
                   case 100:
                       coins.add(Coin.HUNDREDROOPE);
                       break;
               }
           }
           vm.InsertedCoinGetProductAndChange(coins, product);
           vm.noOfItemsAfterSelecting();
           vm.screen.ShowMenu();
       }
    }
}
