package io.github.deepaksood619.khatriapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private EditText etAddItem;
    private EditText etOne;
    private EditText etTwo;
    private EditText etThree;
    private EditText etFour;
    private EditText etFive;
    private EditText etSix;
    private EditText etSeven;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etAddItem = findViewById(R.id.et_add_item);
        etOne = findViewById(R.id.et_one);
        etTwo = findViewById(R.id.et_two);
        etThree = findViewById(R.id.et_three);
        etFour = findViewById(R.id.et_four);
        etFive = findViewById(R.id.et_five);
        etSix = findViewById(R.id.et_six);
        etSeven = findViewById(R.id.et_seven);
        btnAddItem = findViewById(R.id.btn_add_item);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etAddItem.getText().toString().trim();
                if (content.equals("")) {
                    etAddItem.setError("Please enter item name");
                } else {
                    Toast.makeText(AddActivity.this, "Added Item", Toast.LENGTH_SHORT).show();
                    final User user = new User();
                    user.setName(content);
                    user.setOne(etOne.getText().toString());
                    user.setTwo(etTwo.getText().toString());
                    user.setThree(etThree.getText().toString());
                    user.setFour(etFour.getText().toString());
                    user.setFive(etFive.getText().toString());
                    user.setSix(etSix.getText().toString());
                    user.setSeven(etSeven.getText().toString());

                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            Singleton.getInstance().getDb().userDao().insertAll(user);
                        }
                    });

                    etAddItem.setText("");
                    etOne.setText("");
                    etTwo.setText("");
                    etThree.setText("");
                    etFour.setText("");
                    etFive.setText("");
                    etSix.setText("");
                    etSeven.setText("");
                }
            }
        });
    }
}
