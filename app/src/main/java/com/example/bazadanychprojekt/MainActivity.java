package com.example.bazadanychprojekt;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GameDB gameDB;
    private Button button;
    private EditText editTextName, editTextAge, editTextPrice;
    private Spinner spinner;
    private CheckBox checkBox;
    private ListView listView;
    private ArrayAdapter<Game> arrayAdapter;
    private List<Game> games;
    private Game ClickedGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        spinner = findViewById(R.id.spinner);
        checkBox = findViewById(R.id.checkBoxMulti);
        button = findViewById(R.id.button);
        editTextPrice = findViewById(R.id.editTextPrice);
        gameDB = Room.databaseBuilder(
                getApplicationContext(),
                GameDB.class,
                "games_db"
        ).allowMainThreadQueries().build();
        gameDB.returnGameDAO().InsertInDB(
                new Game("COD", 50, true, 25, "fps")
        );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game game = new Game(
                        editTextName.getText().toString(),
                        Integer.parseInt(editTextPrice.getText().toString()),
                        checkBox.isChecked(),
                        Integer.parseInt(editTextAge.getText().toString()),
                        spinner.getSelectedItem().toString()
                );
                gameDB.returnGameDAO().InsertInDB(game);
                games.add(game);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        listView = findViewById(R.id.listView);
        games = gameDB.returnGameDAO().SelectAllGames();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, games);
        listView.setAdapter(arrayAdapter);
    }
}