package com.example.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.*;

public class DetailActivity extends Activity  {

    private Button bt;
    private Button bt_delete;

    TextView et_date;
    TextView et_time;
    TextView et_distance;
    TextView et_average_speed;
    TextView et_average_cadence;
    TextView et_comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        setContentView(R.layout.activity_detail);
        //
        bt = findViewById(R.id.bt_return);
        bt_delete = findViewById(R.id.bt_delete);

        et_date = findViewById(R.id.et_date);
        et_time  = findViewById(R.id.et_time);
        et_distance  = findViewById(R.id.et_distance);
        et_average_speed  = findViewById(R.id.et_average_speed);
        et_average_cadence  = findViewById(R.id.et_average_cadence);
        et_comment  = findViewById(R.id.et_comment);


        Ride ride = (Ride) getIntent().getSerializableExtra("ride");


        et_date.setText(ride.getDate());
        et_time.setText(ride.getTime());
        et_distance.setText(ride.getDistance());
        et_average_speed.setText(ride.getAverage_speed());
        et_average_cadence.setText(ride.getAverage_cadence());
        et_comment.setText(ride.getComment());

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( !DateValidation.isValidDate(et_date.getText().toString()) || !DateValidation.isValidtime(et_time.getText().toString())||et_distance.getText().toString().length() == 0 || et_average_cadence.getText().toString().length() == 0 || et_average_speed.getText().toString().length() == 0 ){
                    Toast.makeText(DetailActivity.this,"Please enter proper data and only the comment field may be left blank.",Toast.LENGTH_SHORT ).show();

                }else {


                    Intent intent = new Intent();
                    Ride ride1 = new Ride(et_time.getText().toString(),et_distance.getText().toString(),et_date.getText().toString(),et_average_speed.getText().toString(),et_average_cadence.getText().toString(),et_comment.getText().toString());

                    intent.putExtra("ride1",ride1);

                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent();
            setResult(2,intent);
            finish();


            }
        });


    }


}
