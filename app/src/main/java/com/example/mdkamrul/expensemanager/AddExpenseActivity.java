package com.example.mdkamrul.expensemanager;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Database.TableAttributes;
import com.example.mdkamrul.expensemanager.Model.Expense;

import java.text.SimpleDateFormat;

import static com.example.mdkamrul.expensemanager.R.id.editTextPurchaseDate;

public class AddExpenseActivity extends AppCompatActivity {
        EditText editTextProductName;
        EditText editTextProductPrice;
        Button buttonSave;
        DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        editTextProductName = (EditText) findViewById(R.id.editTextProductName);
        editTextProductPrice = (EditText) findViewById(R.id.editTextProductPrice);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        db = new DatabaseHelper(AddExpenseActivity.this);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = editTextProductName.getText().toString();
                Double productPrice = Double.parseDouble (editTextProductPrice.getText().toString());
                java.util.Calendar c = java.util.Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String purchaseDate = df.format(c.getTime());

                Expense expense = new Expense();
                expense.setProductName(productName);
                expense.setProductCost(productPrice);
                expense.setExpenseDate(purchaseDate);

                db.addExpense (expense);
                Intent mainActivityIntent = new Intent(AddExpenseActivity.this,MainActivity.class);
                startActivity(mainActivityIntent);

            }
        });

    }
}
