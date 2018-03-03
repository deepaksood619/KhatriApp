package io.github.deepaksood619.khatriapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayItem extends AppCompatActivity {

    private static final String TAG = DisplayItem.class.getSimpleName();

    private TextView tvItemName;
    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvThree;
    private TextView tvFour;
    private TextView tvFive;
    private TextView tvSix;
    private TextView tvSeven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);

        tvItemName = findViewById(R.id.tv_item_name);
        tvOne = findViewById(R.id.tv_one);
        tvTwo = findViewById(R.id.tv_two);
        tvThree = findViewById(R.id.tv_three);
        tvFour = findViewById(R.id.tv_four);
        tvFive = findViewById(R.id.tv_five);
        tvSix = findViewById(R.id.tv_six);
        tvSeven = findViewById(R.id.tv_seven);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        User user = null;
        if (bundle != null) {
            user = (User) bundle.getSerializable("user_object");
        }

        if (user != null) {
            Log.d(TAG, user.toString());
            tvItemName.setText(user.getName());
            tvOne.setText(user.getOne());
            tvTwo.setText(user.getTwo());
            tvThree.setText(user.getThree());
            tvFour.setText(user.getFour());
            tvFive.setText(user.getFive());
            tvSix.setText(user.getSix());
            tvSeven.setText(user.getSeven());
        }


    }
}
