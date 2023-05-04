package com.crio.lombok;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Main {

   public static void main(String[] args) {
    // uncomment below line after adding constructor to the Trade class
    Trade tradeWithParameters = new Trade("AAPL", 50, LocalDate.now());
    // TradeData tradeWithParameters1 = new TradeData("AAPL", 50, LocalDate.now());
    TradeData tradeWithParameters2 = new TradeData(); //because NO any field in the TradeData class is marked as required


    /* uncomment below lines & ensure they run w/o errors
    /* once you add getters & setters
    */
    String symbol = tradeWithParameters.getSymbol();
    int quantity = tradeWithParameters.getQuantity();
    LocalDate today = tradeWithParameters.getPurchaseDate();

    // tradeWithParameters.setSymbol("GOOGL");
    // tradeWithParameters.setQuantity(1000000);
    // tradeWithParameters.setPurchaseDate(today.minusDays(10));

    // System.out.println(tradeWithParameters);
    

    // uncomment below line after using @Data annotation
    // TradeData tradeData = new TradeData("AAPL", 50, LocalDate.now());

    System.out.println("Running completed");
  }
}