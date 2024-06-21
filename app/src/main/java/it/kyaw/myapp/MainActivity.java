package it.kyaw.myapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import it.kyaw.myapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final String myName = "htetaung99kyaw@gmail.com";
    private final String myPassword = "demon1357";

    private static final int REQUEST_READ_STORAGE_PERMISSION = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
    }

    private void initListener() {
        binding.loginButton.setOnClickListener(v -> {
            String name = binding.username.getText().toString();
            String password = binding.etPassword.getText().toString();

                if (name.equals(myName) && password.equals(myPassword)) {
                    Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_SHORT).show();
                    Intent allApp = new Intent(this, AllApp.class);
                    if (allApp != null) {
                        startActivity(allApp);
                    }
                } else {
                    if (!name.equals(myName)) {
                        Toast.makeText(this, "Wrong User Name", Toast.LENGTH_LONG).show();
                        binding.username.setText("");
                    } else {
                        Toast.makeText(this, "Wrong Password", Toast.LENGTH_LONG).show();
                        binding.etPassword.setText("");
                    }
                }
//            }


        }
        );
    }
}