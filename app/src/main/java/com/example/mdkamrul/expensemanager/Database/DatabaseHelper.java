package com.example.mdkamrul.expensemanager.Database;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.mdkamrul.expensemanager.Model.Expense;
import com.example.mdkamrul.expensemanager.Model.Income;

import java.util.ArrayList;

import static android.R.attr.data;
import static android.R.attr.saveEnabled;
import static android.R.attr.theme;
import static android.R.attr.thickness;
import static android.R.attr.value;
import static android.R.attr.version;

/**
 * Created by mdkamrul on 04-Jan-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DatabaseName = "addExpense.db";

    public DatabaseHelper(Context context) {
        super(context, DatabaseName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableAttributes expenseTableAttributes = new TableAttributes();
    String addExpenseQuery = expenseTableAttributes.createExpenseTableQuery();
        try {
            db.execSQL(addExpenseQuery);
            Log.i("Create", "Table Created");
        } catch (SQLiteException e) {
            Log.i("Create Error", e.toString());
        }

        String addIncomeQuery = expenseTableAttributes.createIncomeTableQuery ();
        try {
            db.execSQL(addIncomeQuery);
            Log.i("Create Income Table","Income Table Created");
        }catch (SQLiteException e){
            Log.i("Income Table Error",e.toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    public ArrayList<Expense> getAllPurchasedProducts() {
        SQLiteDatabase fetchAllProducts = this.getReadableDatabase();
        ArrayList<Expense> allProducts = new ArrayList<Expense>();
        String query = "Select * From " +TableAttributes.ADDEXPENSETABLENAME;
        Cursor cursor = fetchAllProducts.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Expense expense = new Expense();
            expense.setProductName(cursor.getString(cursor.getColumnIndex(TableAttributes.PRODUCTNAME)));
            expense.setProductCost(cursor.getDouble(cursor.getColumnIndex(TableAttributes.PRODUCTPRICE)));
            expense.setExpenseDate(cursor.getString(cursor.getColumnIndex(TableAttributes.PURCHASEDATE)));
            allProducts.add(expense);
            cursor.moveToNext();
        }
        return allProducts;
    }

    public Double getCostInfo() {
        SQLiteDatabase fetchExpense = this.getReadableDatabase();
        ArrayList<Expense> income = new ArrayList<Expense>();
        Double totalCost = 0.0;
        String query = "Select *From " + TableAttributes.ADDEXPENSETABLENAME;
        Cursor cursor = fetchExpense.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Expense expense = new Expense();
            expense.setProductCost(cursor.getDouble(cursor.getColumnIndex(TableAttributes.PRODUCTPRICE)));
            totalCost=totalCost+expense.getProductCost();
            cursor.moveToNext();
        }
        return totalCost;
    }

    public Double getIncomeInfo() {
        SQLiteDatabase fetchIncomeSum = this.getReadableDatabase();
        ArrayList<Income> sumOfIncome = new ArrayList<Income>();
        String query = "Select *From " + TableAttributes.ADDINCOMETABLENAME;
        Cursor cursor = fetchIncomeSum.rawQuery(query,null);
        Double totallIncome=0.0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Income income = new Income();
            income.setIncome(cursor.getDouble(cursor.getColumnIndex(TableAttributes.INCOME)));
            totallIncome = income.getIncome()+totallIncome;
            //sumOfIncome.add(income);
            cursor.moveToNext();
        }
        //return sumOfIncome;
        return  totallIncome;
    }




    public void addExpense(Expense expense) {
        SQLiteDatabase dbInsert = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableAttributes.PRODUCTNAME, expense.getProductName());
        values.put(TableAttributes.PRODUCTPRICE, expense.getProductCost());
        values.put(TableAttributes.PURCHASEDATE, expense.getExpenseDate());
        try {
            dbInsert.insert(TableAttributes.ADDEXPENSETABLENAME, null, values);
            Log.i("Insertion","Expense Data Inserted");
        } catch (SQLiteException e) {
            Log.i("Insertion Error",e.toString());
        }
    }

    public void addIncome(Income addIncome) {
        SQLiteDatabase insertIncome = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TableAttributes.INCOME,addIncome.getIncome());

        try {
            insertIncome.insert(TableAttributes.ADDINCOMETABLENAME,null,values);
            Log.i("Income Insertion","Income Inserted");
        }catch (SQLiteException e){
            Log.i("Income Error",e.toString());
        }

    }



}
