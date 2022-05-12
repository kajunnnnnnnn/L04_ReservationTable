package sg.edu.rp.c346.id20026955.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPax;
    CheckBox cbEnabled;
    Button btnReserve;
    Button btnReset;
    TextView tvDisplay;
    DatePicker dp;
    TimePicker tp;
    EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etPax = findViewById(R.id.editTextPax);
        cbEnabled = findViewById(R.id.checkBoxSmoke);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.textViewOutput);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        phone = findViewById(R.id.editTextPhone);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2020, 1-1 , 1);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month = dp.getMonth() + 1;
                String name = etName.getText().toString();
                String phoneNum = phone.getText().toString();
                String pax = etPax.getText().toString();
                if (cbEnabled.isChecked()){
                    tvDisplay.setText("Hello " + name + " ("+phoneNum +") "  + ". You have book a table for "+ pax +" at our smoking area on " +  dp.getDayOfMonth() + "/" + month + "/" + dp.getYear() + ". At "+
                            tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ". Thank You~!");
                }
                else{
                    tvDisplay.setText("Hello " + name + " ("+phoneNum +") " +". You have book a table for " + pax + " at our non-smoking area on " +  dp.getDayOfMonth() + "/" + month + "/" + dp.getYear() + ". At "+
                            tp.getCurrentHour() + ":" + tp.getCurrentMinute() + ". Thank You~!");
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 1-1 , 1);
                etName.setText("");
                phone.setText("");
                etPax.setText("");
                tvDisplay.setText("");
                cbEnabled.setChecked(false);
            }
        });
    }
}