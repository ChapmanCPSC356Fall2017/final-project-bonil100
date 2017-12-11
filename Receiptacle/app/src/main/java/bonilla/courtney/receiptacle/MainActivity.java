package bonilla.courtney.receiptacle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends Activity {

    Spinner spinner;
    String[] SPINNERVALUES = {"Food","House Bills","Gas","Shopping","Other"};
    String SpinnerValue;
    Button ENTER;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner =(Spinner)findViewById(R.id.spinner);

        ENTER = (Button)findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, SPINNERVALUES);

        spinner.setAdapter(adapter);

        //Adding setOnItemSelectedListener method on spinner.
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                SpinnerValue = (String)spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        ENTER.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                switch(SpinnerValue){

                    case "Food":
                        intent = new Intent(MainActivity.this, FoodActivity.class);
                        startActivity(intent);
                        break;

                    case "House Bills":
                        intent = new Intent(MainActivity.this, HouseActivity.class);
                        startActivity(intent);
                        break;

                    case "Gas":
                        intent = new Intent(MainActivity.this, GasActivity.class);
                        startActivity(intent);
                        break;

                    case "Shopping":
                        intent = new Intent(MainActivity.this, ShoppingActivity.class);
                        startActivity(intent);
                        break;

                    case "Other":
                        intent = new Intent(MainActivity.this, OtherActivity.class);
                        startActivity(intent);
                        break;


                }
            }
        });

    }
}