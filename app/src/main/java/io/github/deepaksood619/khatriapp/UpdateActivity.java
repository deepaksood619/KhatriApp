package io.github.deepaksood619.khatriapp;

import android.arch.persistence.room.Update;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private static final String TAG = UpdateActivity.class.getSimpleName();

    private EditText etAddItem;
    private EditText etOne;
    private EditText etTwo;
    private EditText etThree;
    private EditText etFour;
    private EditText etFive;
    private EditText etSix;
    private EditText etSeven;
    private Button btnUpdateItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etAddItem = findViewById(R.id.et_add_item);
        etOne = findViewById(R.id.et_one);
        etTwo = findViewById(R.id.et_two);
        etThree = findViewById(R.id.et_three);
        etFour = findViewById(R.id.et_four);
        etFive = findViewById(R.id.et_five);
        etSix = findViewById(R.id.et_six);
        etSeven = findViewById(R.id.et_seven);
        btnUpdateItem = findViewById(R.id.btn_update_item);

        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String content = etAddItem.getText().toString().trim();
                if (content.equals("")) {
                    etAddItem.setError("Please enter item name");
                } else {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            final User user = Singleton.getInstance().getDb().userDao().find(content);
                            Log.d(TAG, "user - " + user);

                            if (user != null) {
                                final User newUser = new User();
                                newUser.setName(content);
                                newUser.setOne(etOne.getText().toString());
                                newUser.setTwo(etTwo.getText().toString());
                                newUser.setThree(etThree.getText().toString());
                                newUser.setFour(etFour.getText().toString());
                                newUser.setFive(etFive.getText().toString());
                                newUser.setSix(etSix.getText().toString());
                                newUser.setSeven(etSeven.getText().toString());

                                Singleton.getInstance().getDb().userDao().update(newUser);
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (user == null) {
                                        Toast.makeText(UpdateActivity.this, "Item not found", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(UpdateActivity.this, "Item Updated", Toast.LENGTH_SHORT).show();
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
