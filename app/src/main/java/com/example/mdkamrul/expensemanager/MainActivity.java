package com.example.mdkamrul.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button addExpense;
    Button addIncome;
    Button expenseDetails;
    Button expenseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addExpense = (Button)findViewById(R.id.buttonAddExpense);
        addIncome = (Button) findViewById(R.id.buttonAddIncome);
        expenseDetails = (Button) findViewById(R.id.buttonExpenseDetails);
        expenseManager = (Button) findViewById(R.id.buttonExpenseManager);

        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddExpense = new Intent(MainActivity.this,AddExpenseActivity.class);
                startActivity(AddExpense);
            }
        });

        expenseDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent expenseDetails = new Intent(MainActivity.this,ExpenseDetailsActivity.class);
                startActivity(expenseDetails);
            }
        });

        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIncome = new Intent(MainActivity.this,IncomeActivity.class);
                startActivity(addIncome);
            }
        });

        expenseManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent expenseManager = new Intent(MainActivity.this,ExpenseManagerActivity.class);
                startActivity(expenseManager);
            }
        });
    }

}
