package com.example.classwork11;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    public static final String FILE_NAME = "MyFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean welcome = preferences.getBoolean("check_box_preference_2", false);

        if (!welcome) {
            Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("check_box_preference_2", true);
            editor.commit();
        }

        if (!hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            checkPermissions();
        }
    }

    public void onClick(View view) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;
        switch (view.getId()) {
            case R.id.btn1:
                preferences = getPreferences(MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("Text", "I am text");
                editor.commit();
                break;

            case R.id.btn2:
                preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("Text", "I am text");
                editor.commit();
                break;

            case R.id.btn3:
                preferences = getPreferences(MODE_PRIVATE);
                Toast.makeText(this, preferences.getString("Text", "DEFAULT"), Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn4:
                preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                Toast.makeText(this, preferences.getString("Text", "DEFAULT"), Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn5:
                startActivity(new Intent(this, PrefActivity.class));
                break;

            case R.id.btn6:
                preferences = PreferenceManager.getDefaultSharedPreferences(this);
                Toast.makeText(this, preferences.getString("edit_text_preference_2", "---"), Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn7:
                saveInternalFile(FILE_NAME, "internal file data");
                break;

            case R.id.btn8:
                String str = readInternalFile(FILE_NAME);
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn9:
                if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File folder = Environment.getExternalStorageDirectory();
                        folder = new File(folder.getAbsolutePath() + "/MyApp/MyFolder");
                        if (!folder.exists()) {
                            if (folder.mkdirs()) {
                                saveExternalFile(folder, FILE_NAME, "External file data");
                            }
                        }
                    }
                }
                break;

            case R.id.btn10:
                if (hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File folder = Environment.getExternalStorageDirectory();
                        folder = new File(folder.getAbsolutePath() + "/MyApp/MyFolder");
                        if (folder.exists()) {
                            String s = readExternalFile(folder,FILE_NAME);
                            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }
    }

    private void saveInternalFile(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE)));
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readInternalFile(String fileName) {
        try {
            StringBuilder builder = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            reader.close();

            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            requestPermissions(permissions, 0);
        }
    }

    private boolean hasPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void saveExternalFile(File folder, String fileName, String data) {
        try {
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File(folder, fileName);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readExternalFile(File folder, String fileName) {
        File file = new File(folder, fileName);

        try {
            if (file.exists()) {
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
                return builder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
