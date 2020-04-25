package ru.falchio.myretrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RetrofitActivity extends AppCompatActivity {
    private RetrofitPresenter retrofitPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ImageView image=findViewById(R.id.image);

        retrofitPresenter = new RetrofitPresenter();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            retrofitPresenter.getString();
            Log.e("TAG", "onCreate: " + retrofitPresenter.getAvaPath());
            Picasso.get().load(retrofitPresenter.getAvaPath()).into(image);

        });

    }

}
