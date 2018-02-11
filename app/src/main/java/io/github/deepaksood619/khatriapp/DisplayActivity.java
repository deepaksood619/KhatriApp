package io.github.deepaksood619.khatriapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private static final String TAG = DisplayActivity.class.getSimpleName();

    private EditText etEnterItem;
    private Button btnDisplay;

    private TextView tvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        etEnterItem = findViewById(R.id.et_enter_item);
        btnDisplay = findViewById(R.id.btn_display);
        tvItem = findViewById(R.id.tv_item);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String content = etEnterItem.getText().toString().trim().toLowerCase();

                if (content.equals("")) {
                    etEnterItem.setError("Please enter item");
                } else {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            final User user = Singleton.getInstance().getDb().userDao().find(content);
                            Log.d(TAG, "user - " + user);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String result = "Item not found";
                                    if (user != null) {
                                        result = user.toString();
                                    }
                                    tvItem.setText(result);
                                }
                            });

                        }
                    });
                }
            }
        });
    }
}
