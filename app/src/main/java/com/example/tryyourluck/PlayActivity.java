package com.example.tryyourluck;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    ImageView iv_wheel;
    RadioButton rb_red;
    RadioButton rb_black;
    Random r;
    DBHelper dbHelper;

    int degree = 0, degree_old = 0;
    private static final float FACTOR = 4.86f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        button = findViewById(R.id.button);
        textView= findViewById(R.id.textView);
        iv_wheel=findViewById(R.id.iv_wheel);
        rb_red=findViewById(R.id.rb_red);
        rb_black=findViewById(R.id.rb_black);

        r = new Random();

        dbHelper = new DBHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degree_old = degree % 360;
                degree = r.nextInt(3600) + 720;
                final SQLiteDatabase database = dbHelper.getWritableDatabase();
                final ContentValues contentValues = new ContentValues();

                RotateAnimation rotate = new RotateAnimation(degree_old, degree, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setText("");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String txt=currentNumber(360 - (degree % 360));
                        String black="черное";
                        String red="красное";
                        String win="Вы выйграли";
                        String lose="Вы проиграли";
                        if (rb_black.isChecked()) {
                            if (txt == black) {
                                textView.setText("Вы выйграли");
                                contentValues.put(DBHelper.KEY_RESULT,win);
                                String stavka="Ставка: черное, выпало: черное";
                                contentValues.put(DBHelper.KEY_STAVKA,stavka);
                            }
                            else {
                                textView.setText("Вы проиграли");
                                contentValues.put(DBHelper.KEY_RESULT,lose);
                                String stavka="Ставка: черное, выпало: красное";
                                contentValues.put(DBHelper.KEY_STAVKA,stavka);
                            }
                        }
                        if (rb_red.isChecked()) {
                            if (txt == red) {
                                textView.setText("Вы выйграли");
                                contentValues.put(DBHelper.KEY_RESULT,win);
                                String stavka="Ставка: красное, выпало: красное";
                                contentValues.put(DBHelper.KEY_STAVKA,stavka);
                            }
                            else {
                                textView.setText("Вы проиграли");
                                contentValues.put(DBHelper.KEY_RESULT,lose);
                                String stavka="Ставка: красное, выпало: черное";
                                contentValues.put(DBHelper.KEY_STAVKA,stavka);
                            }
                        }
                        database.insert(DBHelper.TABLE_CONTACTS,null, contentValues);
                    }
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                iv_wheel.startAnimation(rotate);
            }
        });
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }
    public String currentNumber(int degrees) {
        String text = "";
        if (degrees >= (FACTOR * 1) && degrees < (FACTOR * 3)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 3) && degrees < (FACTOR * 5)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 5) && degrees < (FACTOR * 7)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 7) && degrees < (FACTOR * 9)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 9) && degrees < (FACTOR * 11)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 11) && degrees < (FACTOR * 13)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 13) && degrees < (FACTOR * 15)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 15) && degrees < (FACTOR * 17)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 17) && degrees < (FACTOR * 19)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 19) && degrees < (FACTOR * 21)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 21) && degrees < (FACTOR * 23)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 23) && degrees < (FACTOR * 25)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 25) && degrees < (FACTOR * 27)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 27) && degrees < (FACTOR * 29)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 29) && degrees < (FACTOR * 31)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 31) && degrees < (FACTOR * 33)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 33) && degrees < (FACTOR * 35)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 35) && degrees < (FACTOR * 37)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 37) && degrees < (FACTOR * 39)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 39) && degrees < (FACTOR * 41)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 41) && degrees < (FACTOR * 43)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 43) && degrees < (FACTOR * 45)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 45) && degrees < (FACTOR * 47)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 47) && degrees < (FACTOR * 49)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 49) && degrees < (FACTOR * 51)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 51) && degrees < (FACTOR * 53)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 53) && degrees < (FACTOR * 55)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 55) && degrees < (FACTOR * 57)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 57) && degrees < (FACTOR * 59)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 59) && degrees < (FACTOR * 61)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 61) && degrees < (FACTOR * 63)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 63) && degrees < (FACTOR * 65)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 65) && degrees < (FACTOR * 67)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 67) && degrees < (FACTOR * 69)) {
            text = "черное";
        }
        if (degrees >= (FACTOR * 69) && degrees < (FACTOR * 71)) {
            text = "красное";
        }
        if (degrees >= (FACTOR * 71) && degrees < (FACTOR * 73)) {
            text = "черное";
        }
        if ((degrees >= (FACTOR * 73) && degrees < 360) || (degrees >= 0 && degrees < (FACTOR * 1))) {
            text = "зеленое";
        }
        return text;
    }
}