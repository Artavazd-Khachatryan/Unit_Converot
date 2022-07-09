package com.test.best.unitconverterpro.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.test.best.unitconverterpro.R;
import com.test.best.unitconverterpro.converters.AreaConverter;
import com.test.best.unitconverterpro.converters.DigitalStorage;
import com.test.best.unitconverterpro.converters.FuelConsumptionConverter;
import com.test.best.unitconverterpro.converters.LengthConverter;
import com.test.best.unitconverterpro.converters.MassConverter;
import com.test.best.unitconverterpro.converters.SpeedConverter;
import com.test.best.unitconverterpro.converters.TemperatureConverter;
import com.test.best.unitconverterpro.converters.TimeConverter;
import com.test.best.unitconverterpro.converters.VolumeConverter;
import com.test.best.unitconverterpro.section.Section;
import com.test.best.unitconverterpro.section_factory.SectionFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SectionActivity extends AppCompatActivity {

    Spinner svFrom, svTo;
    EditText etValue;
    TextView tvResult, tvResultTitle, tvTitle;
    ImageView ivTitleImage;
    Button btnCalculate;

    String section = "";
    String sectionTo = "";
    String sectionFrom = "";


    Map<String, Double> sectionMap;
    Map<String, Integer> titleImageMap;
    List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        initView();

        getIntentSection();

        getSectionMap(section);
        ivTitleImage.setImageDrawable(getDrawable(titleImageMap.get(section)));

        setSpinerData();

        setSpinnerItemClick();

        setButtonCalculateListener();


        setEditTextChangeListener();


    }


    private void initView() {
        svFrom = findViewById(R.id.sv_from);
        svTo = findViewById(R.id.sv_to);
        etValue = findViewById(R.id.et_value);
        etValue.setText("1");
        tvResult = findViewById(R.id.tv_result);
        tvResultTitle = findViewById(R.id.tv_result_title);
        tvTitle = findViewById(R.id.tv_title);
        btnCalculate = findViewById(R.id.btn_calculate);

        ivTitleImage = findViewById(R.id.iv_image);
    }

    private void getIntentSection() {
        if (getIntent() != null)
            section = getIntent().getStringExtra("section");
    }


    private void getSectionMap(String section) {
        sectionMap = SectionFactory.getSectionMap(section);
        titleImageMap = SectionFactory.getSectionTitleImage();
    }


    private void setSpinerData() {
        Set<String> titleSet = sectionMap.keySet();

        titleList = new ArrayList<>(titleSet);

        Collections.sort(titleList);

        sectionTo = titleList.get(0);
        sectionFrom = titleList.get(0);

        ArrayAdapter<String> adapterFrom = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, titleList);

        ArrayAdapter<String> adapterTo = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, titleList);

        svFrom.setAdapter(adapterFrom);
        svTo.setAdapter(adapterTo);

        svTo.setSelection(1);
    }


    private void setSpinnerItemClick() {
        svFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sectionFrom = titleList.get(position);
                //calculate();
                tvResult.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        svTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sectionTo = titleList.get(position);
                //calculate();
                tvResult.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setButtonCalculateListener() {
        btnCalculate.setOnClickListener(v -> calculate());
    }

    private void setEditTextChangeListener() {
        etValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvResult.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void calculate() {

        double result = 0;
        if (review()) {
            double value = Double.valueOf(etValue.getText().toString().trim());

            switch (section) {
                case Section.TEMPERATURE:
                    result = TemperatureConverter.convertTemperature(value, sectionTo, sectionFrom);
                    break;
                case Section.LENGTH:
                    result = LengthConverter.convertLength(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.MASS:
                    result = MassConverter.convertMass(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.SPEED:
                    result = SpeedConverter.convertSpeed(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.VOLUME:
                    result = VolumeConverter.convertVolume(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.AREA:
                    result = AreaConverter.convertArea(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.FUEL_CONSUMPTION:
                    result = FuelConsumptionConverter.convertFuelConsumption(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.TIME:
                    result = TimeConverter.convertTime(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
                case Section.DIGITAL_STORAGE:
                    result = DigitalStorage.convertDigitalStorage(value, sectionMap.get(sectionTo), sectionMap.get(sectionFrom));
                    break;
            }

            showResult(result, section);

        }
    }

    private void showResult(double result, String section) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        tvResult.setText(decimalFormat.format(result));
        tvResultTitle.setText(" " + etValue.getText().toString() + " " + sectionFrom + " = " + tvResult.getText().toString() + " " + sectionTo);
        tvTitle.setText(section.toUpperCase());
        ivTitleImage.setImageDrawable(getDrawable(titleImageMap.get(section)));
    }


    private boolean review() {
        if (etValue.getText().toString().trim().isEmpty()) {
            etValue.setError("No Value");
            return false;
        }

        try {
            Double.valueOf(etValue.getText().toString().trim());
        } catch (NumberFormatException e) {
            etValue.setError("Value is not a number");
            return false;
        }

        return true;
    }
}
