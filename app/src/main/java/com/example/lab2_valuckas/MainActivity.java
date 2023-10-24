package com.example.lab2_valuckas;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Button btnCount;

    TextView tvMain;

    TextCounter textCounter;

    Spinner spSelectionOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edUserInput = findViewById(R.id.edUserInput);
        this.btnCount = findViewById(R.id.btnCount);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectionOptions = (Spinner) findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection_options,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);

        textCounter = new TextCounter();
    }

    public void onBtnCountClick(View view) {
        String selectedItem = this.spSelectionOptions.getSelectedItem().toString();
        if(selectedItem.equalsIgnoreCase("Symbols")){
            int result = TextCounter.countSymbols(this.edUserInput.getText().toString());
            Log.i("CountResult", String.valueOf(result));

            this.tvMain.setText(String.valueOf(result));
        }
        else if(selectedItem.equalsIgnoreCase("Words")){
            int result = textCounter.countWords(this.edUserInput.getText().toString());
            Log.i("CountResult", String.valueOf(result));

            this.tvMain.setText(String.valueOf(result));
        } else{
            Toast.makeText(this, "Not implemented", Toast.LENGTH_LONG).show();
        }

    }
}