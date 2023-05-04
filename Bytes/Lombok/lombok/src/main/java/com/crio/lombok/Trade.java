package com.crio.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter @Setter
@ToString
public class Trade {
  
  private String symbol;
  private int quantity;
  private LocalDate purchaseDate;

  // Trade(String symbol, int quantity, LocalDate purchaseDate){
  //   this.symbol = symbol;
  //   this.quantity = quantity;
  //   this.purchaseDate = purchaseDate;
  // }

  // public String getSymbol() {
  //   return symbol;
  // }

  // public void setSymbol(String symbol) {
  //   this.symbol = symbol;
  // }

}
