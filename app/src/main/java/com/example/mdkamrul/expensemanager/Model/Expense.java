package com.example.mdkamrul.expensemanager.Model;

import java.util.Date;

/**
 * Created by mdkamrul on 04-Jan-17.
 */

public class Expense {



    public String productName;
    public String expenseDate;
    public Double productCost;

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    @Override
    public String toString() {
        return
                "ProductName: " + productName + "\n" +
                "Expense Date: " + expenseDate + "\n" +
                "Product Cost: " + productCost ;
    }

}
