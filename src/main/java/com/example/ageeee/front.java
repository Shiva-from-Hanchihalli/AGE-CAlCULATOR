package com.example.ageeee;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.util.TimeZone;
public class front extends AppCompatActivity {

    private TextView description;
    private EditText byear;
    private EditText bmonth;
    private EditText bday;
    private EditText ageyear; 
    private EditText agemonth;
    private EditText ageday;
    private EditText interest;
    private EditText duration;
    private EditText year;
    private EditText month;
    private EditText day;
    private TextView result;
    private TextView ciresult;
    private EditText birthDay;
    private Button calc;


    final Calendar cal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        description = (TextView) findViewById(R.id.tvResult);
        result = (TextView) findViewById(R.id.etbday);
        byear = (EditText) findViewById(R.id.etBirthdayYear);
        bmonth = (EditText) findViewById(R.id.etBirthdayMonth);
        bday = (EditText) findViewById(R.id.etBirthdayDay);
        ageyear = (EditText) findViewById(R.id.etAgeYear);
        agemonth = (EditText) findViewById(R.id.etAgeMonth);
        ageday = (EditText) findViewById(R.id.etAgeDay);
        year = (EditText) findViewById(R.id.etYear);
        month = (EditText) findViewById(R.id.etMonth);
        day = (EditText) findViewById(R.id.tvResult);
        calc = (Button) findViewById(R.id.buttonCalculate);
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        String yr = String.valueOf(calendar.get(Calendar.YEAR));
        int thismn = (calendar.get(Calendar.MONTH)) + 1;
        String mn = String.valueOf(thismn);
        String da = String.valueOf(calendar.get(Calendar.DATE));
        ageyear.setText(yr);
        agemonth.setText(mn);
        ageday.setText(da);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                try {
                    int birthYear = Integer.parseInt(byear.getText().toString());
                    int birthMonth = Integer.parseInt(bmonth.getText().toString());
                    int birthDay = Integer.parseInt(bday.getText().toString());
                    int ageYear = Integer.parseInt(ageyear.getText().toString());
                    int ageMonth = Integer.parseInt(agemonth.getText().toString());
                    int ageDay = Integer.parseInt(ageday.getText().toString());
                    Calendar birthCalendar = Calendar.getInstance();
                    birthCalendar.set(birthYear, birthMonth - 1, birthDay);
                    int dayOfWeek = birthCalendar.get(Calendar.DAY_OF_WEEK);


                    if (ageMonth > birthMonth && ageDay > birthDay) {
                        int ageYearDiff = ageYear - birthYear;
                        int ageMonthDiff = ageMonth - birthMonth;
                        int ageDayDiff = ageDay - birthDay;
                        if (birthDay < 32 && ageDay < 32 && ageMonth < 13 && birthMonth < 13) {
                            year.setText(String.valueOf(ageYearDiff + " Years"));
                            month.setText(String.valueOf(ageMonthDiff + " Months"));
                            day.setText(String.valueOf((ageDayDiff + " Days")));
                            result.setText(getDayOfWeek(dayOfWeek));
                        } else {
                            Toast.makeText(getApplicationContext(), "Please enter valid day and month!",

                                    Toast.LENGTH_SHORT).show();

                        }
                    } else if (ageMonth > birthMonth && ageDay <= birthDay) {
                        long ageYearDiff = (ageYear - birthYear);
                        long ageMonthDiff = (ageMonth - birthMonth) - 1;
                        long ageDayDiff = 0;
                        if (ageMonth == 1 || ageMonth == 3 || ageMonth == 5 || ageMonth
                                == 7 || ageMonth == 8 || ageMonth == 10 || ageMonth == 12) {
                            ageDayDiff = (ageDay - birthDay) + 31;
                        } else if (ageMonth == 2) {
                            ageDayDiff = (ageDay - birthDay) + 28;
                        } else {
                            ageDayDiff = (ageDay - birthDay) + 30;
                        }
                        if (birthDay < 32 && ageDay < 32 && ageMonth < 13 && birthMonth < 13) {
                            year.setText(String.valueOf(ageYearDiff + " Years"));
                            month.setText(String.valueOf(ageMonthDiff + " Months"));
                            day.setText(String.valueOf((ageDayDiff + " Days")));
                            result.setText(getDayOfWeek(dayOfWeek));
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Please enter valid day and month!", Toast.LENGTH_SHORT).show();
                        }
                    } else if (ageMonth <= birthMonth && ageDay > birthDay) {
                        long ageYearDiff = (ageYear - birthYear) - 1;


                        long ageMonthDiff = (ageMonth - birthMonth) + 12;
                        long ageDayDiff = ageDay - birthDay;
                        if (birthDay < 32 && ageDay < 32 && ageMonth < 13 && birthMonth < 13) {
                            year.setText(String.valueOf(ageYearDiff + " Years"));
                            month.setText(String.valueOf(ageMonthDiff + " Months"));
                            day.setText(String.valueOf((ageDayDiff + " Days")));
                            result.setText(getDayOfWeek(dayOfWeek));
                        } else {
                            Toast.makeText(getApplicationContext(), "Please enter valid day and month!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else if (ageMonth <= birthMonth && ageDay <= birthDay) {
                        long ageYearDiff = (ageYear - birthYear) - 1;
                        long ageMonthDiff = (ageMonth - birthMonth) + 11;
                        long ageDayDiff;
                        if (ageMonth == 1 || ageMonth == 3 || ageMonth == 5 || ageMonth == 7 || ageMonth == 8 ||
                                ageMonth == 10 || ageMonth == 12) {
                            ageDayDiff = (ageDay - birthDay) + 31;
                        } else if (ageMonth == 2) {
                            ageDayDiff = (ageDay - birthDay) + 28;
                        } else {
                            ageDayDiff = (ageDay - birthDay) + 30;
                        }
                        if (birthDay < 32 && ageDay < 32 && ageMonth < 13 && birthMonth < 13) {
                            year.setText(String.valueOf(ageYearDiff + " Years"));
                            month.setText(String.valueOf(ageMonthDiff + " Months"));
                            day.setText(String.valueOf((ageDayDiff + " Days")));
                            result.setText(getDayOfWeek(dayOfWeek));
                        } else {

                            Toast.makeText(getApplicationContext(), "Please enter valid day and month!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Month Problem",

                                Toast.LENGTH_SHORT).show();


                    }



                } finally {

                }
            }
        });
    }


    private String getDayOfWeek(int dayOfWeek) {
        String[ ] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday"};
        return daysOfWeek[dayOfWeek - 1];
    }
}
