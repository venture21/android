package com.venture.android.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


public class UnitActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLength, btnArea, btnWeight;                   // Button 3ea
    LinearLayout layoutLength, layoutArea, layoutWeight;    // Layout 3ea
    Spinner spLength1, spLength2;
    Spinner spArea1, spArea2;
    Spinner spWeight1, spWeight2;
    EditText etLengthIn;
    EditText etAreaIn;
    EditText etWeightIn;
    TextView tvValue11, tvValue12, tvValue13;
    TextView tvValue14, tvValue15, tvValue16;
    TextView tvValue31, tvValue32, tvValue33;

    private TextView textView;

    String lengthUnit1, lengthUnit2;
    String areaUnit1, areaUnit2;
    String weightUnit1, weightUnit2;
    String sValue="";

    ArrayList<String> lengthUnit = new ArrayList<>();
    ArrayList<String> areaUnit  = new ArrayList<>();
    ArrayList<String> weightUnit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        // Button 3ea, Spinner 6ea, EditText 3ea
        btnLength = (Button)  findViewById(R.id.btnLength);
        btnArea   = (Button)  findViewById(R.id.btnArea);
        btnWeight = (Button)  findViewById(R.id.btnWeight);
        spLength1 = (Spinner) findViewById(R.id.spLength1);
        spLength2 = (Spinner) findViewById(R.id.spLength2);
        spArea1   = (Spinner) findViewById(R.id.spArea1);
        spArea2   = (Spinner) findViewById(R.id.spArea2);
        spWeight1 = (Spinner) findViewById(R.id.spWeight1);
        spWeight2 = (Spinner) findViewById(R.id.spWeight2);
        etLengthIn  = (EditText)findViewById(R.id.etLengthIn);
        etAreaIn    = (EditText)findViewById(R.id.etAreaIn);
        etWeightIn  = (EditText)findViewById(R.id.etWeightIn);
        tvValue11 = (TextView)findViewById(R.id.tvValue11);
        tvValue12 = (TextView)findViewById(R.id.tvValue12);
        tvValue13 = (TextView)findViewById(R.id.tvValue13);
        tvValue14 = (TextView)findViewById(R.id.tvValue14);
        tvValue15 = (TextView)findViewById(R.id.tvValue15);
        tvValue16 = (TextView)findViewById(R.id.tvValue16);


        // Layout 3ea (For visablity, unvisability)
        layoutLength = (LinearLayout) findViewById(R.id.layoutLength);
        layoutArea   = (LinearLayout) findViewById(R.id.layoutArea);
        layoutWeight = (LinearLayout) findViewById(R.id.layoutWeight);

        /*
        et = (EditText) findViewById(R.id.editText3);
        Toast.makeText(this, "EditText:"+et.getText().toString(), Toast.LENGTH_SHORT);
        */

        btnLength.setOnClickListener(this);
        btnArea.setOnClickListener(this);
        btnWeight.setOnClickListener(this);
        etAreaIn.setOnClickListener(this);
        etLengthIn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sValue = (String) s.toString();
                convLength();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        makeSpinnerData();
        // 3.1 Spinner Data 아답터로 생성
        // length spinner
        ArrayAdapter<String> length_adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, lengthUnit
                // 컨텍스트              스피너에서 사용할 레이아웃          배열데이터
        );
        // area spinner
        ArrayAdapter<String> area_adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, areaUnit
                // 컨텍스트              스피너에서 사용할 레이아웃          배열데이터
        );
        // weight spinner
        ArrayAdapter<String> weight_adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, weightUnit
                // 컨텍스트              스피너에서 사용할 레이아웃          배열데이터
        );



        // 3.2 spinner 아답터 등록
        spLength1.setAdapter(length_adapter);
        spLength2.setAdapter(length_adapter);
        spArea1.setAdapter(area_adapter);
        spArea2.setAdapter(area_adapter);
        spWeight1.setAdapter(weight_adapter);
        spWeight2.setAdapter(weight_adapter);

        // 3.3 스피너 리스너에 등록
        // length spinner 1
        spLength1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                lengthUnit1 = lengthUnit.get(position);
                    convLength();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        // length spinner 2
        spLength2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                lengthUnit2 = lengthUnit.get(position);
               // Toast.makeText(UnitActivity.this,"선택된단위="+lengthUnit.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // area spinner 1
        spArea1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(UnitActivity.this,"선택된단위="+areaUnit.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        // area spinner 2
        spArea2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(UnitActivity.this,"선택된단위="+areaUnit.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }









    @Override
    public void onClick(View view) {
        // 클릭이 일어나면 모두 지운다.
        layoutLength.setVisibility(View.GONE);
        layoutArea.setVisibility(View.GONE);
        layoutWeight.setVisibility(View.GONE);


        // 클릭된 버튼에 해당하는 레이아웃만 보여준다.
        switch (view.getId()) {
            case R.id.btnLength:
                layoutLength.setVisibility(View.VISIBLE);
                break;
            case R.id.btnArea:
                layoutArea.setVisibility(View.VISIBLE);
                break;
            case R.id.btnWeight:
                layoutWeight.setVisibility(View.VISIBLE);
                break;
            case R.id.etAreaIn:
                //Toast.makeText(this, "EditText:"+etArea.getText().toString(), Toast.LENGTH_SHORT);
                break;
            case R.id.etWeightIn:
                //Toast.makeText(this, "EditText:"+etWeight.getText().toString(), Toast.LENGTH_SHORT);
                break;
        }
    }



    private void makeSpinnerData() {
        int index;

        // length
        lengthUnit.add("mm");
        lengthUnit.add("cm");
        lengthUnit.add("m");
        lengthUnit.add("km");
        lengthUnit.add("in");
        lengthUnit.add("ft");

        // area
        areaUnit.add("m2");
        areaUnit.add("a");
        areaUnit.add("ha");
        areaUnit.add("km2");
        areaUnit.add("ft2");
        areaUnit.add("yd2");

        // weight
        weightUnit.add("mg");
        weightUnit.add("g");
        weightUnit.add("kg");
        weightUnit.add("t");
        weightUnit.add("kt");
        weightUnit.add("gr");
    }

    public void convLength() {
        double inputValue;
        if(sValue.equals("")){
            sValue=0+"";
        }

        inputValue = Integer.parseInt(sValue);

        switch(lengthUnit1) {
            case "mm":
                break;
            case "cm":
                inputValue=inputValue*10;

                break;
            case "m":
                inputValue=inputValue*1000;
                break;
            case "km":
                inputValue=inputValue*1000000;
                break;
            case "in":
                inputValue=inputValue*0.03937;
                break;
            case "ft":
                inputValue=inputValue*0.003281;
                break;
        }
        // mm로 계산이 이루어진다.
        tvValue11.setText(inputValue+"mm");
        tvValue12.setText(inputValue/10+"cm");
        tvValue13.setText(inputValue/1000 +"m");
        tvValue14.setText(inputValue/1000000 +"km");
        tvValue15.setText(inputValue*0.0393701 +"in");
        tvValue16.setText(inputValue*0.0032808 +"ft");
    }
}

