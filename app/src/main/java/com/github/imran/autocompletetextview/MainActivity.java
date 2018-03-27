package com.github.imran.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoComp;
    ImageView arrow;
    AutoCompleteTextView autoComp1;
    ImageView arrow1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoComp = (AutoCompleteTextView) findViewById(R.id.autoComp);
        autoComp.setThreshold(2);
        arrow = (ImageView) findViewById(R.id.arrow);

        autoComp1 = (AutoCompleteTextView) findViewById(R.id.autoComp1);
        autoComp1.setThreshold(2);
        arrow1 = (ImageView) findViewById(R.id.arrow1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.spinnerRoot));
        autoComp.setAdapter(adapter);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoComp.showDropDown();
            }
        });

        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoComp1.showDropDown();
            }
        });

        autoComp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name = adapter.getItem(position).toString();
                int idSpinner = getResources().getIdentifier(name, "array",MainActivity.this.getPackageName());

                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(idSpinner));
                autoComp1.setAdapter(adapter1);

                Toast.makeText(MainActivity.this,
                        adapter.getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this,
                        adapter1.getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}