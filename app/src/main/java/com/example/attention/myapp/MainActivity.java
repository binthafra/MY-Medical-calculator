package com.example.attention.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    double convertionRate = 2.2;
    double weightEntered;
    double convertedWeight;

    EditText editText;
    RadioGroup radioGroup;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.weight);
        radioGroup = findViewById(R.id.myRadioGroup);
        RadioButton1 = findViewById(R.id.weight1);
        RadioButton2 = findViewById(R.id.weight2);
        textView = findViewById(R.id.result);

    }

    public void convert(View view) {

        weightEntered = Double.parseDouble(editText.getText().toString());
        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        if (RadioButton1.isChecked()) {
            if (weightEntered <= 500) {
                convertedWeight = weightEntered / convertionRate;
                textView.setText(decimalFormat.format(convertedWeight) + " Kilogram");
            } else {
                Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_SHORT).show();
            }
        }

        if (RadioButton2.isChecked()) {
            if (weightEntered <= 225) {
                convertedWeight = weightEntered * convertionRate;
                textView.setText(decimalFormat.format(convertedWeight) + " Pounds");
            } else {
                Toast.makeText(MainActivity.this, "Kilogram must be less than 225", Toast.LENGTH_SHORT).show();
            }


        }


}

    public void onClickradioButton(View view) {


        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.weight1:
                if (checked) {
                    Toast.makeText(MainActivity.this, "Pound to Kilogram Checked!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.weight2:
                if (checked) {
                    Toast.makeText(MainActivity.this, "Kilogram to Pound Checked!", Toast.LENGTH_SHORT).show();
                }
                break;


        }
    }
}
