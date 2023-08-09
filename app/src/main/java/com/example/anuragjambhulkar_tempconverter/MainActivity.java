package com.example.anuragjambhulkar_tempconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTemperature;
    private RadioGroup radioGroup;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTemperature = findViewById(R.id.editTemperature);
        radioGroup = findViewById(R.id.radioGroup);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        double temperature = Double.parseDouble(editTemperature.getText().toString());

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        double convertedTemperature = 0;

        if (selectedRadioButtonId == R.id.radioCelsiusToFahrenheit) {
            convertedTemperature = celsiusToFahrenheit(temperature);
        } else if (selectedRadioButtonId == R.id.radioFahrenheitToCelsius) {
            convertedTemperature = fahrenheitToCelsius(temperature);
        } else if (selectedRadioButtonId == R.id.radioKelvinToCelsius) {
            convertedTemperature = kelvinToCelsius(temperature);
        }else if (selectedRadioButtonId == R.id.radioCelsiusToKelvin) {
            convertedTemperature = celsiusToKelvin(temperature);
        }

        resultText.setText(String.format("%.2f", convertedTemperature));
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    private double celsiusToKelvin(double kelvin) {
        return kelvin + 273.15;
    }
}
