package com.example.mdkamrul.expensemanager.Model;

/**
 * Created by mdkamrul on 04-Jan-17.
 */

public class Income {
    public Double income;

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return
                "Income: " + income ;
    }



}
