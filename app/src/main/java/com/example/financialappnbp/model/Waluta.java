package com.example.financialappnbp.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Waluta {
    private String table;
    private String currency;
    private String code;
    private ArrayList<KursWaluty> rates = new ArrayList<>();

}
