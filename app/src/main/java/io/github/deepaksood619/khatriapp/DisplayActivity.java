package io.github.deepaksood619.khatriapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private static final String TAG = DisplayActivity.class.getSimpleName();

    private RecyclerView rvDisplayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        rvDisplayItems = findViewById(R.id.rv_display_items);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvDisplayItems.setLayoutManager(layoutManager);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<User> users = Singleton.getInstance().getDb().userDao().getAll();

                RecyclerView.Adapter adapter = new DisplayAdapter(users);
                rvDisplayItems.setAdapter(adapter);
            }
        });
    }
}
