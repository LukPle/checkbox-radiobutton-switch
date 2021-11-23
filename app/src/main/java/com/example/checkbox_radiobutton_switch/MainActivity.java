package com.example.checkbox_radiobutton_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

/**
 * The app should let the user make a food order.
 * This Activity presents different input options to the user in order to specify the order.
 * These input options include CheckBoxes, RadioButtons and a Switch.
 * The following CheckoutActivity shows the input parameters after a click on a Button.
 *
 * Layout File: activity_main.xml
 *
 * @author Lukas Plenk
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    // These are variables that are used for referencing an extra in an intent
    public static final String EXTRA_FOOD = "com.example.checkbox_radiobutton_switch.EXTRA_FOOD";
    public static final String EXTRA_PAYMENT = "com.example.checkbox_radiobutton_switch.EXTRA_PAYMENT";
    public static final String EXTRA_BONUS = "com.example.checkbox_radiobutton_switch.EXTRA_BONUS";

    private CheckBox checkBoxBurger, checkBoxSushi, checkBoxPizza, checkBoxPasta;
    private RadioGroup radioGroup;
    private RadioButton selectedRadioButton;
    private Switch switchBonus;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxBurger = findViewById(R.id.cb_burger);
        checkBoxSushi = findViewById(R.id.cb_sushi);
        checkBoxPizza = findViewById(R.id.cb_pizza);
        checkBoxPasta = findViewById(R.id.cb_pasta);

        radioGroup = findViewById(R.id.rb_group);

        switchBonus = findViewById(R.id.switch_bonus);
        switchBonus.setOnCheckedChangeListener(this);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        intent = new Intent(MainActivity.this, CheckoutActivity.class);
    }

    /**
     * The onClick method gathers all data from the input options.
     * It also calls the next Activity.
     * @param view ist the view that was clicked on.
     */
    @Override
    public void onClick(View view) {

        getCheckBoxes();
        getRadioButtons();
        getSwitch();

        startActivity(intent);
    }

    /**
     * This method inspects the change on the Switch.
     * The text should show yes when checked and no when not checked.
     * @param compoundButton is a special Button with two states like a Switch.
     * @param isChecked tells if the Switch is been checked.
     */
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        if (isChecked) {

            switchBonus.setText("Yes");
        }
        else {

            switchBonus.setText("No");
        }
    }

    /**
     * Method for getting the text of the CheckBoxes into an extra of an intent.
     */
    private void getCheckBoxes() {

        StringBuilder checkBoxResult = new StringBuilder();

        if (checkBoxBurger.isChecked()) {

            checkBoxResult.append(" " +checkBoxBurger.getText().toString());
        }
        if (checkBoxSushi.isChecked()) {

            checkBoxResult.append(" " +checkBoxSushi.getText().toString());
        }
        if (checkBoxPizza.isChecked()) {

            checkBoxResult.append(" " +checkBoxPizza.getText().toString());
        }
        if (checkBoxPasta.isChecked()) {

            checkBoxResult.append(" " +checkBoxPasta.getText().toString());
        }

        intent.putExtra(EXTRA_FOOD, checkBoxResult.toString());
    }

    /**
     * Method for getting the text of the RadioButtons into an extra of an intent.
     * The variable radioId is the clicked RadioButton from the RadioGroup.
     */
    private void getRadioButtons() {
        
        int radioId = radioGroup.getCheckedRadioButtonId();

        selectedRadioButton = findViewById(radioId);

        intent.putExtra(EXTRA_PAYMENT, selectedRadioButton.getText());
    }

    /**
     * Method for getting the text of the Switch into an extra of an intent.
     */
    private void getSwitch() {

        intent.putExtra(EXTRA_BONUS, switchBonus.getText());
    }
}