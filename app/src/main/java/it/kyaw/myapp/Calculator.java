package it.kyaw.myapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    Button  bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btAdd, btSub, btMul, btDiv, btEqu, btClear;

    EditText etCalculator;
    TextView tvOperation, tvOperator;

    ImageView btn_back;

    private String operator;


//    private ActivityMainBinding binding;
//    private String operator;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        initUI();
        btnBack();



    }


    private void btnBack() {
        btn_back.setOnClickListener(view -> {
            finish();
        });
    }

    //
    private void initUI() {
//        bt0 = findViewById(R.id.bt0);
//        bt1 = findViewById(R.id.bt1);
//        bt2 = findViewById(R.id.bt2);
//        bt3 = findViewById(R.id.bt3);
//        bt4 = findViewById(R.id.bt4);
//        bt5 = findViewById(R.id.bt5);
//        bt6 = findViewById(R.id.bt6);
//        bt7 = findViewById(R.id.bt7);
//        bt8 = findViewById(R.id.bt8);
//        bt9 = findViewById(R.id.bt9);
        btAdd = findViewById(R.id.btAdd);
        btSub = findViewById(R.id.btSubtract);
        btMul = findViewById(R.id.btMultiply);
        btDiv = findViewById(R.id.btDivide);
        btEqu = findViewById(R.id.btEqual);
        btClear = findViewById(R.id.btClear);
        etCalculator = findViewById(R.id.etCalculator);
        tvOperation = findViewById(R.id.tvOperation);
        tvOperator = findViewById(R.id.tvOperator);
        btn_back = findViewById(R.id.btn_back);
    }

    public void onNumberClicked(View view) {
        Button btn = (Button) view;
        Log.d("Myat", btn.getText().toString());
        if (etCalculator.getText().toString().equals("0"))
            etCalculator.setText(btn.getText().toString());
        else
            etCalculator.append(btn.getText().toString());
    }

    public void onOperatorClicked(View view) {
        int operator = view.getId();
        if (operator == R.id.btAdd) {
            this.operator = "+";
            tvOperation.setText(etCalculator.getText().toString());
            etCalculator.setText("0");
            tvOperator.setText(this.operator);
        } else if (operator == R.id.btSubtract) {
            this.operator = "-";
            tvOperation.setText(etCalculator.getText().toString());
            etCalculator.setText("0");
            tvOperator.setText(this.operator);
        } else if (operator == R.id.btMultiply) {
            this.operator = "*";
            tvOperation.setText(etCalculator.getText().toString());
            etCalculator.setText("0");
            tvOperator.setText(this.operator);
        } else if (operator == R.id.btDivide) {
            this.operator = "/";
            tvOperation.setText(etCalculator.getText().toString());
            etCalculator.setText("0");
            tvOperator.setText(this.operator);
        } else if (operator == R.id.btEqual) {
            int firstNum = Integer.parseInt(tvOperation.getText().toString());
            int secondNum = Integer.parseInt(etCalculator.getText().toString());
            calculate(firstNum, secondNum);
            tvOperation.setText("");
            tvOperator.setText("");
        }
    }

    private void calculate(int firstNum, int secondNum) {
        int result = 0;
        if(this.operator.equals("+")){
            result = firstNum + secondNum;
        } else if (this.operator.equals("-")) {
            result = firstNum - secondNum;
        } else if (this.operator.equals("*")) {
            result = firstNum * secondNum;
        } else {
            result = firstNum / secondNum;
        }
        etCalculator.setText(String.valueOf(result));
    }

    public void onClearClicked(View view) {
        etCalculator.setText("");
    }
}


//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import it.thomas.myallapp.databinding.ActivityMainBinding;

//import com.example.calculator.databinding.ActivityMainBinding;

//public class Calculator extends AppCompatActivity {
//    private ActivityMainBinding binding;
//    private String operator;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//    }

//    public void onNumberClicked(View view) {
//        Button btn = (Button) view; // Up casting & Down casting
//        Log.d("SAI", btn.getText().toString());
//        if (binding.etCalculator.getText().toString().equals("0"))
//            binding.etCalculator.setText(btn.getText().toString());
//        else
//            binding.etCalculator.append(btn.getText().toString());
//    }
//
//    public void onOperatorClicked(View view) {
//        int operator = view.getId();
//        if (operator == R.id.btAdd) {
//            // Add Operator Clicked
//            this.operator = "+";
//
//            binding.tvOperation.setText(binding.etCalculator.getText().toString());
//            binding.etCalculator.setText("0");
//            binding.tvOperator.setText(this.operator);
//        } else if (operator == R.id.btSubtract) {
//            this.operator = "-";
//
//            binding.tvOperation.setText(binding.etCalculator.getText().toString());
//            binding.etCalculator.setText("0");
//            binding.tvOperator.setText(this.operator);
//        } else if (operator == R.id.btMultiply) {
//            this.operator = "*";
//
//            binding.tvOperation.setText(binding.etCalculator.getText().toString());
//            binding.etCalculator.setText("0");
//            binding.tvOperator.setText(this.operator);
//        } else if (operator == R.id.btDivide) {
//            this.operator = "/";
//
//            binding.tvOperation.setText(binding.etCalculator.getText().toString());
//            binding.etCalculator.setText("0");
//            binding.tvOperator.setText(this.operator);
//        } else if (operator == R.id.btEqual) {
//            int firstNumber = Integer.parseInt(binding.tvOperation.getText().toString());
//            int secondNumber = Integer.parseInt(binding.etCalculator.getText().toString());
//            calculate(firstNumber, secondNumber);
//            binding.tvOperation.setText("");
//            binding.tvOperator.setText("");
//        }
//
//    }
//
//
//    private void calculate(int firstNumber, int secondNumber) {
//        int result = 0;
//        if (this.operator.equals("+")) {
//            result = firstNumber + secondNumber;
//        } else if (this.operator.equals("-")) {
//            result = firstNumber - secondNumber;
//        } else if (this.operator.equals("*")) {
//            result = firstNumber * secondNumber;
//        } else {
//            result = firstNumber / secondNumber;
//        }
//        // int to string
//        binding.etCalculator.setText(String.valueOf(result));
//    }
//
//    public void onClearClicked(View view) {
//        binding.etCalculator.setText("");
//    }
//
//}