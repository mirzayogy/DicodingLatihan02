package com.mirzayogy.dicodinglatihan02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnMoveActivity;
    private Button btnMoveWithDataActivity;
    private Button btnMoveWithObject;
    private Button btnDialPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity = (Button)findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject = (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialPhone = (Button)findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("DicodingAcademy");
                mPerson.setAge(5);
                mPerson.setEmail("academy@dicoding.com");
                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "081210841382";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}
