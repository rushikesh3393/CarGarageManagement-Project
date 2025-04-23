package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenerateReceiptModel {
    private int apid;
    private String cname;
    private String vnumber;
    private String servicetype;
    private int serviceprice;
    private String sparename;
    private int spareqty;
    private int spareamt;
    private int totalamount;

}
