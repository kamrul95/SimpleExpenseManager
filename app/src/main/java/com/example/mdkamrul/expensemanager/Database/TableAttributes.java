package com.example.mdkamrul.expensemanager.Database;

/**
 * Created by mdkamrul on 04-Jan-17.
 */

public class TableAttributes {
    public static final String ADDEXPENSETABLENAME="addExpense";
    public static final String PRODUCTNAME="productName";
    public static final String PRODUCTPRICE="productPrice";
    public static final String PURCHASEDATE="purchaseDate";
    public String createExpenseTableQuery() {
        return "Create Table "+ADDEXPENSETABLENAME+" (addExpense_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                PRODUCTNAME+" TEXT," +
                 PRODUCTPRICE+" DOUBLE," +
                PURCHASEDATE+" TEXT)  ";
    }

    public  static  final String ADDINCOMETABLENAME="addIncome";
    public static final String INCOME="income";


    public String createIncomeTableQuery() {
        return  "Create Table " + ADDINCOMETABLENAME+"(addIncome_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
        INCOME+" DOUBLE)  ";
     }
}
