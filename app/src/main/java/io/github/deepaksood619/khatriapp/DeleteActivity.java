package io.github.deepaksood619.khatriapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    private static final String TAG = DeleteActivity.class.getSimpleName();

    private EditText etEnterItem;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etEnterItem = findViewById(R.id.et_enter_item);
        btnDelete = findViewById(R.id.btn_delete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
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

                            if (user != null) {
                                Singleton.getInstance().getDb().userDao().delete(user);
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (user == null) {
                                        Toast.makeText(DeleteActivity.this, "Item not found", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(DeleteActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}
