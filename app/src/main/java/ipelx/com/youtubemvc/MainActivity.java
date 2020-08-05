package ipelx.com.youtubemvc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MovieAdapter adapter;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        databaseHelper = new DatabaseHelper(MainActivity.this);

        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new MovieAdapter(MainActivity.this,databaseHelper.getAllMovies());
        rv.setAdapter(adapter);


    }
}