package com.example.checkbox_radiobutton_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * This Activity gets the various information as extras from the previous Activity.
 * Those values get shown as TextViews.
 *
 * Layout File: activity_checkout.xml
 */
public class CheckoutActivity extends AppCompatActivity {

    private TextView yourFood;
    private TextView yourPayment;
    private TextView yourBonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        yourFood = findViewById(R.id.your_food);
        yourPayment = findViewById(R.id.your_payment);
        yourBonus = findViewById(R.id.your_bonus);

        Intent intent = getIntent();

        yourFood.setText("Food:" +intent.getStringExtra(MainActivity.EXTRA_FOOD));
        yourPayment.setText("Payment via: " +intent.getStringExtra(MainActivity.EXTRA_PAYMENT));
        yourBonus.setText("Bonus: " +intent.getStringExtra(MainActivity.EXTRA_BONUS));
    }
}