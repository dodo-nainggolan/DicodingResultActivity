package com.example.moveforresultactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int REQUEST_CODE = 100;
    Button btnMoveForResult;
    TextView tvResult;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveResult.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveResult.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveResult.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
