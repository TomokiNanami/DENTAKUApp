package com.example.testdentakuapp.dentakuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {


    Button mButton[];

    int mID[] = { R.id.No0, R.id.No1, R.id.No2, R.id.No3, R.id.No4, R.id.No5, R.id.No6, R.id.No7,   // XMLファイル上の各ボタンのID付け
            R.id.No8, R.id.No9, R.id.NoPlus, R.id.NoMinus, R.id.NoMultiply, R.id.NoBleak,
            R.id.NoCancel, R.id.NoPoint, R.id.Noequal, R.id.No000,  R.id.No001, R.id.No002,
            R.id.No003, R.id.No004, R.id.No005,};

    private final int KEY_CANCEL = 14;                                                              // それぞれのボタンに数字をつける

    TextView mTextView;

    int beforeStatus = 0;                                                                           // 前の処理

    int total = 0;                                                                                  // 合計

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.number);                                           // XMLのnumberってTextViewを取得
        mTextView.setText(String.valueOf(0));                                                       // 実行後最初に表示される文字・数字

        mButton = new Button[mID.length];

        for (int i = 0; i < mID.length; i++) {
           mButton[i] = (Button) findViewById(mID[i]);
           mButton[i].setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < mID.length; i++) {
            if (view.equals(mButton[i])){                                                           // Cボタンの処理
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
