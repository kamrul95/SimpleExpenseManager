package com.example.mdkamrul.expensemanager;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Expense;

import java.util.ArrayList;

public class ExpenseDetailsActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listViewDetails;
    ArrayList<Expense> expenseList;
    ArrayAdapter<Expense> expenseArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details);

        listViewDetails = (ListView) findViewById(R.id.listViewExpenseDetails);
        db = new DatabaseHelper(ExpenseDetailsActivity.this);
        expenseList = db.getAllPurchasedProducts ();
        expenseArrayAdapter = new ArrayAdapter<Expense>(ExpenseDetailsActivity.this,android.R.layout.simple_list_item_1,expenseList);
        listViewDetails.setAdapter(expenseArrayAdapter);

    }
}
