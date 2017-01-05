package com.example.mdkamrul.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mdkamrul.expensemanager.Database.DatabaseHelper;
import com.example.mdkamrul.expensemanager.Model.Income;

public class IncomeActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText editTextIncome;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        editTextIncome = (EditText) findViewById(R.id.editTextAddIncome);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        db = new DatabaseHelper(IncomeActivity.this);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double income = Double.parseDouble(editTextIncome.getText().toString());
                Income addIncome = new Income();
                addIncome.setIncome(income);
                db.addIncome (addIncome);
                Intent mainActivityIntent = new Intent(IncomeActivity.this,MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

    }
}
