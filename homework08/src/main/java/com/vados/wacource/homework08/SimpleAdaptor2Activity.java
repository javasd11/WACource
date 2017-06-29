package com.vados.wacource.homework08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SimpleAdaptor2Activity extends AppCompatActivity {
   public static final String KEY_NAME ="name";
   public static final String KEY_LAST_NAME ="lastname";
   public static final String KEY_AGE ="age";

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adaptor2);

        listView = (ListView) findViewById(R.id.lvSimple2);

        ArrayList<Map<String,String>> items = new ArrayList();

        for(int i=0; i<50; i++){
            Map<String,String> item = new HashMap<>();
            item.put(KEY_NAME,"Ivan"+i);
            item.put(KEY_LAST_NAME,"Ivanov"+i);
            item.put(KEY_AGE,String.valueOf(20 +i));

            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, items,R.layout.student_item,
                new String[]{KEY_NAME,KEY_LAST_NAME,KEY_AGE},
                new int[]{R.id.textFirstName,R.id.textLAstName,R.id.textAge});

        listView.setAdapter(adapter);

    }
}
