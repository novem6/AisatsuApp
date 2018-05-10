package jp.techacademy.rei.tanaka.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

        mTextView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v){
        setTime();
    }

    private void setTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if ((hourOfDay >2) && (hourOfDay <=9)){
                            mTextView.setText("おはよう");
                        } else if ((hourOfDay >10) && (hourOfDay <= 17)){
                            mTextView.setText("こんにちは");
                        }else if ((hourOfDay > 18) && (hourOfDay <= 24) || (hourOfDay == 1) || (hourOfDay ==0)){
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                12,
                0,
                true);
        timePickerDialog.show();
    }
}
