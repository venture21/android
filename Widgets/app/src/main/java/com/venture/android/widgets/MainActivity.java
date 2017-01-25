package com.venture.android.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnGrid;
    Button calc;

    // 1. 위젯을 정의한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // 2. 정의된 위젯변수에 xml의 위젯 id를 가져와서 담아준다.
        btnGrid = (Button) findViewById(R.id.btnGrid);
        calc = (Button) findViewById(R.id.btnCal);
        // 3. 변수(위젯)을 리스너에 달아준다.
        btnGrid.setOnClickListener(this);
        calc.setOnClickListener(this);

    }

    // onCreate함수 안에서 정의할 수도 있으나 코드의 간결성을 위해 분리

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGrid:
                // 안드로이드 메이저 컴포넌트를 로드하기 위해서는
                // intent를 통해서 로드할 컴포넌트를 지정해야 한다.
                Intent intent = new Intent(this, GridActivity.class);
                                             // 대상이 되는 컴포넌트
                startActivity(intent);
                break;

            case R.id.btnCal:
                Intent intent2 = new Intent(this, CalculatorActivity.class);
                // 대상이 되는 컴포넌트
                startActivity(intent2);
                break;
        }
    }
}
