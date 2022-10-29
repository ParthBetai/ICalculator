package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView result_tv , solution_tv;
    MaterialButton button_plus , button_minus , button_multiply , button_divide , equal;
    MaterialButton button_c , button_openbrac , button_closebrac , button_ac , button_dot ;
    MaterialButton button_0 , button_1 , button_2 , button_3 , button_4 , button_5 , button_6 , button_7 , button_8 , button_9 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_tv = findViewById(R.id.result_tv);
        solution_tv = findViewById(R.id.solution_tv);

        assignid(button_c,R.id.button_c);
        assignid(button_plus,R.id.button_plus);
        assignid(button_minus,R.id.button_minus);
        assignid(button_multiply,R.id.button_multiply);
        assignid(button_divide,R.id.button_divide);
        assignid(equal,R.id.equal);
        assignid(button_dot,R.id.button_dot);
        assignid(button_ac,R.id.button_ac);
        assignid(button_closebrac,R.id.button_closebrac);
        assignid(button_openbrac,R.id.button_openbrac);
        assignid(button_0,R.id.button_0);
        assignid(button_1,R.id.button_1);
        assignid(button_2,R.id.button_2);
        assignid(button_3,R.id.button_3);
        assignid(button_4,R.id.button_4);
        assignid(button_5,R.id.button_5);
        assignid(button_6,R.id.button_6);
        assignid(button_7,R.id.button_7);
        assignid(button_8,R.id.button_8);
        assignid(button_9,R.id.button_9);




    }

    void assignid(MaterialButton btn , int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution_tv.getText().toString();

        if (buttonText.equals("AC"))
        {
            solution_tv.setText("");
            result_tv.setText("0");
            return;
        }
        if (buttonText.equals("="))
        {
            solution_tv.setText(result_tv.getText());

            return;
        }
        if(buttonText.equals("+"))
        {
            if (dataToCalculate.endsWith("-"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("+"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("*"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("/"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
        }
        if(buttonText.equals("-"))
        {
            if (dataToCalculate.endsWith("-"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("+"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("*"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("/"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }


        }
        if(buttonText.equals("*"))
        {
            if (dataToCalculate.endsWith("-"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("+"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("*"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("/"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
        }
        if(buttonText.equals("/"))
        {
            if (dataToCalculate.endsWith("-"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("+"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("*"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
            if (dataToCalculate.endsWith("/"))
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }
        }
        if (buttonText.equals("C"))
        {
            int length = solution_tv.getText().length();
            if (length == 1){
                solution_tv.setText("");
                result_tv.setText("0");
                return;
            }

                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);



        }else{
            dataToCalculate = dataToCalculate + buttonText ;
            solution_tv.setText(dataToCalculate);
        }

        solution_tv.setText(dataToCalculate);
        String finalresult = getresult(dataToCalculate);

        if (!finalresult.equals("ERROR")){

            result_tv.setText(finalresult);
        }

    }

    String getresult(String data){

        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
           String finalresult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
           if (finalresult.endsWith(".0"))
           {
               finalresult = finalresult.replace(".0","");
           }
           return finalresult;
        }catch (Exception e){
            return "ERROR";
        }

    }
}