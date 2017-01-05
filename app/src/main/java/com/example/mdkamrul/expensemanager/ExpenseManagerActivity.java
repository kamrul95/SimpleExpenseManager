package com.example.mdkamrul.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Income;

import java.util.ArrayList;


public class ExpenseManagerActivity extends AppCompatActivity {
    TextView textViewExpenseManager;
    TextView textViewCost;
    TextView textViewRemaining;
    ArrayList<Income> incomeArrayList;
    ArrayAdapter<Income> incomeArrayAdapter;
    DatabaseHelper db;
    Double totalIncome;
    Double totalCost;
    Double remaining=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_manager);

        db = new DatabaseHelper(ExpenseManagerActivity.this);
        textViewExpenseManager = (TextView) findViewById(R.id.textViewExpenseManager);
        textViewCost = (TextView) findViewById(R.id.textViewCost);
        textViewRemaining = (TextView) findViewById(R.id.textViewRemaining);
        totalIncome = db.getIncomeInfo();
        //incomeArrayList = db.getIncomeInfo ();
        //incomeArrayAdapter = new ArrayAdapter<Income>(ExpenseManagerActivity.this,android.R.layout.simple_list_item_1,incomeArrayList);
        //listViewIncome.setAdapter(incomeArrayAdapter);
        textViewExpenseManager.setText(totalIncome.toString());
        totalCost = db.getCostInfo ();
        textViewCost.setText(totalCost.toString());
        remaining = totalIncome-totalCost;
        textViewRemaining.setText(remaining.toString());



    }
}
