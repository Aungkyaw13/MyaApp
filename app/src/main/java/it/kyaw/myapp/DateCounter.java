package it.kyaw.myapp;

//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.activity.result.ActivityResult;
//import androidx.activity.result.ActivityResultCallback;
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.activity.result.contract.ActivityResultContracts;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Objects;
//
//import it.thomas.myallapp.databinding.ActivityDateCounterBinding;
//import it.thomas.myallapp.databinding.DialogUserNameInputBinding;
//
//
//
//public class DateCounter extends AppCompatActivity {
//    private ActivityDateCounterBinding binding;
//
//    private static final String BOY = "boy";
//
//    private static final String GIRL = "girl";
//    private SharedPreferences sp;
//
//    private LocalDate selectedDate;
//    LocalDate todayDate = LocalDate.now();
//    private static final int SELECTED_PICTURE = 100;
//    ImageView iv;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityDateCounterBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        sp = getSharedPreferences("date_counter", MODE_PRIVATE);
//        initUI();
//        initListener();
//    }
//
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//    private void initListener() {
//        binding.btDate.setOnClickListener(v -> {
//            DateCount dc = DateCount.calculate(selectedDate.getDayOfMonth(), selectedDate.getMonthValue(), selectedDate.getYear(),
//                    todayDate.getDayOfMonth(), todayDate.getMonthValue(), todayDate.getYear());
//            String date = dc.getYear() + " years / " + dc.getMonth() + " months / " + dc.getDay() + " days";
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            AlertDialog dialog = builder
//                    .setTitle("Anniversary")
//                    .setMessage(date)
//                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.cancel();
//                        }
//                    })
//                    .create();
//            dialog.show();
//        });
//        binding.tvBoy.setOnClickListener(this::nameInputDialog);
//
//        binding.tvGirl.setOnClickListener(this::nameInputDialog);
//
//        binding.ivBoy.setOnClickListener(v -> {
//            uploadPicture(v);
//        });
//
//        binding.ivGirl.setOnClickListener(v -> {
//            uploadPicture(v);
//        });
//
//    }
//
//    private void uploadPicture(View view) {
//        iv = (ImageView) view;
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, SELECTED_PICTURE);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == SELECTED_PICTURE && resultCode == RESULT_OK) {
//            Uri image = data.getData();
//            String imgStr = image.toString();
//            if (iv.getId() == R.id.ivBoy) {
//                saveData(BOY, imgStr);
//            } else {
//                saveData(GIRL, imgStr);
//            }
//            iv.setImageURI(image);
//        }
//    }
//
//    private void initUI() {
//        binding.tvBoy.setText(read(BOY));
//        binding.tvGirl.setText(read(GIRL));
//        selectedDate = fromStringToLocalDate(binding.btDate.getText().toString());
//        long dateBetween = todayDate.toEpochDay() - selectedDate.toEpochDay();
//        String days = dateBetween > 1 ? dateBetween + "Days" : dateBetween + "Day";
//        binding.tvCount.setText(days);
//        binding.ivBoy.setImageURI(Uri.parse(read(BOY)));
//        binding.ivGirl.setImageURI(Uri.parse(read(GIRL)));
//    }
//
//    private LocalDate fromStringToLocalDate(String str) {
//        return LocalDate.parse(str, formatter);
//    }
//
//    private String fromLocalDateToString(LocalDate localDate) {
//        return formatter.format(localDate);
//    }
//
//    private void nameInputDialog(View view) {
//        DialogUserNameInputBinding inputBinding = DialogUserNameInputBinding.inflate(getLayoutInflater());
//        TextView textView = (TextView) view;
//        AlertDialog.Builder nameBuilder = new AlertDialog.Builder(this);
//        AlertDialog nameDialog = nameBuilder.setView(inputBinding.getRoot()).create();
//        nameDialog.show();
//
//        class OnDialogClick implements View.OnClickListener {
//
//            @Override
//            public void onClick(View v) {
//                String name = inputBinding.etName.getText().toString();
//                if (textView.getId() == R.id.tvBoy) {
//                    saveData(BOY, name);
//                } else {
//                    saveData(GIRL, name);
//                }
//                textView.setText(name);
//                nameDialog.cancel();
//            }
//        }
//
//        inputBinding.btConfirm.setOnClickListener(new OnDialogClick());
//        inputBinding.btCancel.setOnClickListener(v -> nameDialog.cancel());
//    }
//
//    private void saveData(String key, String value) {
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString(key, value);
//        editor.apply();
//    }
//
//    private String read(String key) {
//        return sp.getString(key, "");
//    }
//}


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import it.kyaw.myapp.databinding.ActivityDateCounterBinding;
import it.kyaw.myapp.databinding.DialogUserNameBinding;

public class DateCounter extends AppCompatActivity {

    private ActivityDateCounterBinding binding;
    private LocalDate selectedDate;

    private SharedPreferences sp;

    private ImageView  btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUi();
        initListeners();
        btnButton();
    }

    private void btnButton() {
        btn_back.setOnClickListener(view -> {
            finish();
        });
    }

    private void initListeners() {
        binding.tvMale.setOnClickListener(v -> {
            showAlertDialog(v);
        });
        binding.tvFemale.setOnClickListener(v -> {
            showAlertDialog(v);
        });

    }

    private void showAlertDialog(View view) {
        // View vew = new TextView(this); // child to parent -> upcasting (implicit)
        TextView textView = (TextView) view; // parent to child -> downcasting (explicit)
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        DialogUserNameBinding dialogBinding = DialogUserNameBinding.inflate(getLayoutInflater());
        AlertDialog alertDialog = alertBuilder.setView(dialogBinding.getRoot()).create();
        alertDialog.show();

        class OnDialogClick implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                textView.setText(dialogBinding.etName.getText().toString());
                alertDialog.cancel();
            }
        }
        dialogBinding.btCancel.setOnClickListener(v -> alertDialog.cancel());
        // ExoPlayer (Notification)
        dialogBinding.btConfirm.setOnClickListener(new OnDialogClick());

    }


    private void initUi() {

        btn_back = findViewById(R.id.btn_back);
        // min - 26
        selectedDate = fromStringToLocalDate(binding.btDate.getText().toString());
        LocalDate todayDate = null; // todayDate - selectedDate = dateBetween
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            todayDate = LocalDate.now();
        }
        long dateBetween = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateBetween = todayDate.toEpochDay() - selectedDate.toEpochDay();
        }
        String days = dateBetween > 1 ? dateBetween + " Days" : dateBetween + " Day";
        binding.tvDateBetween.setText(days);
    }

    @SuppressLint("NewApi")
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @SuppressLint("NewApi")
    private String fromLocalDateToString(LocalDate localDate) {
        // 01/06/1996
        return formatter.format(localDate);
    }

    @SuppressLint("NewApi")
    private LocalDate fromStringToLocalDate(String str) {
        return LocalDate.parse(str, formatter);
    }

}
