package com.crio.lombok;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
public class TradeData {
  private String symbol;
  private int quantity;
  private LocalDate purchaseDate;
} 