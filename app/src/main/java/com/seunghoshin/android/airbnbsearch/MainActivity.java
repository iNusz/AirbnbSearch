package com.seunghoshin.android.airbnbsearch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    Button btnCheckin, btnCheckout;
    private CalendarView calendarView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setSupportActionBar(toolbar);
        setCalendarButtonText();
        setListener();


    }

    private void setCalendarButtonText() {

        setButtonText(btnCheckin, getString(R.string.hint_start_date), getString(R.string.hint_select_date));
        setButtonText(btnCheckout, getString(R.string.hint_end_date), "-");

    }

    private void setButtonText(Button btn, String upText, String downText){

        // 버튼에 다양한 색깔의 폰트 적용하기
        // 위젯의 android:textAllCaps="false" 적용 필요
        String inText = "<font color='#888888'>" + upText
                + "</font> <br> <font color=\"#fd5a5f\">" + downText + "</font>";
        StringUtil.setHtmlText(btn, inText);
    }

    private void setCheckoutButton(){

        String outText = "<font color='#888888'>" + getString(R.string.hint_start_date)
                + "</font> <br> <font color=\"#fd5a5f\"> - </font>";
        StringUtil.setHtmlText(btnCheckout, outText);
    }


    private void initView() {
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);
        btnCheckin = (Button) findViewById(R.id.btnCheckin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


    }

    private void setListener(){
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                month = month +1 ; // month는 0부터 배열형태로 가져오기 때문에 1을 더해서 합을 맞추어준다
                Log.i("Calendar","year:"+year+", month:"+month+", dayOfMonth: "+dayOfMonth);
                String theDay = year + "-"+month+"-"+dayOfMonth;
                setButtonText(btnCheckin, getString(R.string.hint_start_date), theDay);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


}