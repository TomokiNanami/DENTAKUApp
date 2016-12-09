package com.example.testdentakuapp.dentakuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {


    Button mButton[];

    int mID[] = { R.id.No0, R.id.No1, R.id.No2, R.id.No3, R.id.No4, R.id.No5, R.id.No6, R.id.No7,   
            R.id.No8, R.id.No9, R.id.NoPlus, R.id.NoMinus, R.id.NoMultiply, R.id.NoBleak,
            R.id.NoCancel, R.id.NoPoint, R.id.Noequal, R.id.No000,  R.id.No001, R.id.No002,
            R.id.No003, R.id.No004, R.id.No005,};


    private final int KEY_0 = 0;
    private final int KEY_1 = 1;
    private final int KEY_2 = 2;
    private final int KEY_3 = 3;
    private final int KEY_4 = 4;
    private final int KEY_5 = 5;
    private final int KEY_6 = 6;
    private final int KEY_7 = 7;
    private final int KEY_8 = 8;
    private final int KEY_9 = 9;
    private final int KEY_PLUS = 10;
    private final int KEY_MINUS = 11;
    private final int KEY_MULTIPLY = 12;
    private final int KEY_BLEAK = 13;
    private final int KEY_CANCEL = 14;
    private final int KEY_POINT = 15;
    private final int KEY_EQUAL = 16;
    private final int KEY_001 = 17;
    private final int KEY_002 = 18;
    private final int KEY_003 = 19;
    private final int KEY_004 = 20;
    private final int KEY_005 = 21;


    TextView mTextView;

    int beforeStatus = 0;                                                                           // 前の処理

    int total = 0;                                                                                  // 合計

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.number);

        mButton = new Button[mID.length];

        for (int i = 0; i < mID.length; i++) {
           mButton[i] = (Button) findViewById(mID[i]);
           mButton[i].setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < mID.length; i++) {
            if (view.equals(mButton[i])){
                if (i == KEY_CANCEL) {
                    mTextView.setText("");
                    total = 0;
                    beforeStatus = KEY_CANCEL;
                } else if (i < 10) {
                    String nowValue = mTextView.getText().toString();
                    nowValue = nowValue + i;
                    mTextView.setText(nowValue);
                    beforeStatus = i;
                }
                break;
            }
        }
    }
}
