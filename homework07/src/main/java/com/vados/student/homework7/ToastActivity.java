package com.vados.student.homework7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toasts);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button12:
                simpleToast();
                break;
            case R.id.button13:
                toastWithImage();
                break;
            case R.id.button14:
                customToast();
                break;
        }
    }


    private void simpleToast(){
        Toast toast = Toast.makeText(this, "new  simple toast",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,10);
        toast.show();

    }

    private void toastWithImage(){

        Toast toast = Toast.makeText(this,"toast with image", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);

        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView hiImage = new ImageView(this);
        hiImage.setImageResource(R.drawable.hiimg);
        toastContainer.addView(hiImage,0);
        toast.show();
    }

    private void customToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_layout,(ViewGroup)findViewById(R.id.toast_layout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
