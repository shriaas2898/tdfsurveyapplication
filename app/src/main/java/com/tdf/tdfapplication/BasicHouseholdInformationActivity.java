package com.tdf.tdfapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BasicHouseholdInformationActivity extends AppCompatActivity {

    private String casteName;
    private TextView textView;
    private TextView other;
    private EditText otherTribe;
    private Spinner tribe;
    private String tribeName;
    private CheckBox[] checkBoxes;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_household_information);

        button = findViewById(R.id.basic_household_info_submit);
        textView = findViewById(R.id.respondent_tribe_label);
        tribe= findViewById(R.id.tribe);
        checkBoxes = new CheckBox[3];
        checkBoxes[0] = findViewById(R.id.home);
        checkBoxes[1] = findViewById(R.id.farm);
        checkBoxes[2] = findViewById(R.id.none);

        other = findViewById(R.id.respondent_other_tribe_name);
//        otherTribe = findViewById(R.id.editText);

        final Spinner spinner = findViewById(R.id.caste);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.caste_list,android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(arrayAdapter);

        final ArrayAdapter<CharSequence> tribeAdapter = ArrayAdapter.createFromResource(this,R.array.tribe_list,android.R.layout.simple_spinner_dropdown_item);
        tribeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        tribe.setAdapter(tribeAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                casteName= getResources().getStringArray(R.array.caste_list)[position];
                if(position == 2 || position == 3 ){
                    textView.setVisibility(View.VISIBLE);
                    tribe.setVisibility(View.VISIBLE);
                }else{
                    other.setVisibility(View.GONE);
                    otherTribe.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                casteName = getResources().getStringArray(R.array.village_list)[4];
            }
        });

        tribe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tribeName = getResources().getStringArray(R.array.tribe_list)[position];
                if(position == 6){
                    other.setVisibility(View.VISIBLE);
                    otherTribe.setVisibility(View.VISIBLE);
                } else {
                    other.setVisibility(View.GONE);
                    otherTribe.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkBoxValue ="";

                for(int i =0; i<checkBoxes.length;i++){
                    if(checkBoxes[i].isChecked()){
                        checkBoxValue = checkBoxValue + " " + checkBoxes[i].getText().toString();
                    }
                }

                String value = "Caste: " + casteName + "Tribe:" + tribeName + "Other Tribe name:" + otherTribe.getText().toString()+ checkBoxes;
                Log.i("HOUSE_HOLD_VALUES",value);
                finish();
            }
        });
    }
}
