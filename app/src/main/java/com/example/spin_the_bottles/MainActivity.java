/* Developed by Jaspreet Singh
   Bottle image by https://favpng.com/
*/
package com.example.spin_the_bottles;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private ImageView bottle;
    private boolean rotating = false;
    int last_value = 0;
    private Random random_value = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle = findViewById(R.id.button);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyAnimation();
            }
        });
    }


    private void onMyAnimation() {
        if (!rotating) {
            final int int_rotate = random_value.nextInt(1800);
            int pivotX = bottle.getWidth() / 2;
            int pivotY = bottle.getHeight() / 2;
            Animation animation = new RotateAnimation(last_value, int_rotate, pivotX, pivotY);
            animation.setDuration(2500);
            animation.setFillAfter(true);
            bottle.startAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    rotating = true;
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    rotating = false;
                }
                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            last_value = int_rotate;
        }
    }
}