package com.example.colourpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
        // Initialize variable
    TextView colour_code, rgb_value ;
    View colour_view;
    SeekBar sb_red,sb_green, sb_blue;
    int red, green, blue;
    LinearLayout linearLayout;
    String rgbcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign variable
        colour_code = findViewById(R.id.colour_code);
        rgb_value = findViewById(R.id.rgb_value);
        sb_red = findViewById(R.id.sbred);
        sb_green =  findViewById(R.id.sbgreen);
        sb_blue = findViewById(R.id.sbblue);
        linearLayout = findViewById(R.id.linearLayout);
        sb_red.setOnSeekBarChangeListener(this);
        sb_green.setOnSeekBarChangeListener(this);
        sb_blue.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {

        //switch case
        switch(seekBar.getId()){
            case R.id.sbred :
                // set red id
                red = i;
                break;
            case R.id.sbgreen:
                //set green id
                green = i;
                break;
            case R.id.sbblue:
                // set blue id
                blue = i;
        }

        // set colour on background
        linearLayout.setBackgroundColor(Color.rgb(red, green, blue));

        //initialize hexa colourcode
        rgbcode = HexCode(red, green, blue);


        //set code on Text view
        colour_code.setText(rgbcode.toUpperCase());

        // set value on text view
        rgb_value.setText(String.format("RGB(%d, %d, %d)", red,green, blue));

        Log.i("colour",rgbcode);
        if (rgbcode.equals("#000")){

            colour_code.setTextColor(Color.WHITE);
            rgb_value.setTextColor(Color.WHITE);

        }else {

            colour_code.setTextColor(Color.BLACK);
            rgb_value.setTextColor(Color.BLACK);
        }
    }

    private String HexCode(int red, int green, int blue) {
        String code ;
        code = "#";

         // add red
        code = code + Integer.toHexString(red);

        // add green
        code = code + Integer.toHexString(green);

        // add blue
        code = code + Integer.toHexString(blue);
        Log.i("code", code);

        // return colour code
        return code;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}