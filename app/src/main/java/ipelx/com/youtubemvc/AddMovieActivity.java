package ipelx.com.youtubemvc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMovieActivity extends AppCompatActivity {

    EditText edmovie;
    Button movieadd,movieshow;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        edmovie = findViewById(R.id.edmovie);
        movieadd = findViewById(R.id.movieadd);
        movieshow = findViewById(R.id.movieshow);
        db = new DatabaseHelper(AddMovieActivity.this);

        movieadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edmovie.getText().toString();
                db.insert(str);
            }
        });

        movieshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddMovieActivity.this,MainActivity.class));
            }
        });
    }
}