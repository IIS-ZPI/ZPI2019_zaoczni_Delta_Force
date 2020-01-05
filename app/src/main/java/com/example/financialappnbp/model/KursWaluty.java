package com.example.financialappnbp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KursWaluty {
    private String no;
    private String effectiveDate;
    private float mid;
}
