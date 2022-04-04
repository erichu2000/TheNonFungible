package com.example.thenonfungible.View;
import static java.lang.Thread.sleep;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.thenonfungible.R;

public class MeShowme extends AppCompatActivity{

    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_showme);
        final ImageView imageView =findViewById(R.id.showme);
        Button button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            //create click event
            @Override
            public void onClick(View view) {

                i++;
                if (i%2==0){

                    imageView.setImageResource(R.drawable.pjacket);
                }else {

                    imageView.setImageResource(R.drawable.ppinkshirt);
                }
            }
        });
    }
}
