package com.vados.student.homework7;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

public class DialogsActivity extends AppCompatActivity {
    final int DIALOG_TIME = 100;
    final int DIALOG_EXIT = 300;
    final int DIALOG_DATE = 200;

    private TextView tvDate;
    private TextView tvTime;
    private ProgressDialog progressDialog;
    private Handler handler;

    private int myHour = 14;
    private int myMinute = 35;

    private int myYear = 2011;
    private int myMonth = 02;
    private int myDay = 03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvDate = (TextView) findViewById(R.id.tvDate);
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                showMyDialog(DIALOG_TIME);
                break;
            case R.id.tvDate:
                showMyDialog(DIALOG_DATE);
                break;
            case R.id.btnExit:
                showMyDialog(DIALOG_EXIT);
                break;
            case R.id.btnHoriz:
                showHorizontalProgessDialog();
                break;
            case R.id.btnDefault:
                showDefaultProgtessDialog();
                break;
        }
    }


    private void showMyDialog(int id) {
        switch (id) {
            case DIALOG_TIME:
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        myHour = hourOfDay;
                        myMinute = minute;
                        tvTime.setText("Time is " + myHour + ":" + myMinute);
                    }
                }, myHour, myMinute, true).show();
                break;

            case DIALOG_DATE:
                new DatePickerDialog(this, onDateSetListener, myYear, myMonth, myDay).show();
                break;

            case DIALOG_EXIT:
                alertDialog().create().show();
        }
//        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myYear = year;
            myMonth = month;
            myDay = dayOfMonth;
            tvDate.setText("Today is " + myDay + "/" + myMonth+ "/" + myYear);
        }
    };

    private AlertDialog.Builder alertDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        // заголовок
        adb.setTitle(R.string.exit);
        // сообщение
        adb.setMessage(R.string.save_data);
        // иконка
        adb.setIcon(android.R.drawable.ic_dialog_info);
        // кнопка положительного ответа
        adb.setPositiveButton(R.string.yes, myClickListener);
        // кнопка отрицательного ответа
        adb.setNegativeButton(R.string.no, myClickListener);
        // кнопка нейтрального ответа
        adb.setNeutralButton(R.string.cancel, myClickListener);
        // создаем диалог

        return adb;

    }

    OnClickListener myClickListener = new OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    saveData();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    finish();
                    break;
                case Dialog.BUTTON_NEUTRAL:
                    break;

            }
        }
    };

    private void saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_LONG).show();
    }

    private void showDefaultProgtessDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");
        progressDialog.setButton(Dialog.BUTTON_POSITIVE, "Ok", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        progressDialog.show();
    }

    private void showHorizontalProgessDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");
        // меняем стиль на индикатор
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // устанавливаем максимум
        progressDialog.setMax(2148);
        // включаем анимацию ожидания
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        handler = new Handler() {
            public void handleMessage(Message msg) {
                // выключаем анимацию ожидания
                progressDialog.setIndeterminate(false);
                if (progressDialog.getProgress() < progressDialog.getMax()) {
                    // увеличиваем значения индикаторов
                    progressDialog.incrementProgressBy(50);
                    progressDialog.incrementSecondaryProgressBy(75);
                    handler.sendEmptyMessageDelayed(0, 100);
                } else {
                    progressDialog.dismiss();
                }
            }
        };
        handler.sendEmptyMessageDelayed(0, 2000);
    }
}
