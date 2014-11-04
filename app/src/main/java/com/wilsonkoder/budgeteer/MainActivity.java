package com.wilsonkoder.budgeteer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    int totalBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextPurchaseAmount = (EditText)findViewById(R.id.editTextPurchaseAmount);
        final EditText editTextTotalBudget = (EditText)findViewById(R.id.editTextTotalBudget);
        final TextView textViewBudgetLeft = (TextView)findViewById(R.id.textViewBudgetLeft);
        Button buttonMakePurchase = (Button)findViewById(R.id.buttonMakePurchase);
        Button buttonSetTotalBudget = (Button)findViewById(R.id.buttonSetTotalBudget);

        buttonMakePurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalBudget -= Integer.parseInt(editTextPurchaseAmount.getText().toString());
                textViewBudgetLeft.setText("Budget Left: " + totalBudget);
                if(totalBudget < 5000)
                {
                    textViewBudgetLeft.setTextColor(Color.rgb(255, 0,0 ));
                }
                else if(totalBudget > 5000)
                {
                    textViewBudgetLeft.setTextColor(Color.rgb(0, 255, 0));
                }
            }
        });

        buttonSetTotalBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalBudget = Integer.parseInt(editTextTotalBudget.getText().toString());
                textViewBudgetLeft.setText("Budget Left: " + totalBudget);

                if(totalBudget < 5000)
                {
                    textViewBudgetLeft.setTextColor(Color.rgb(255, 0,0 ));
                }
                else if(totalBudget > 5000)
                {
                    textViewBudgetLeft.setTextColor(Color.rgb(0, 255, 0));
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
