package it.kyaw.myapp.Voucher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.kyaw.myapp.databinding.ActivityProductAddBinding;


public class ProductAdd extends AppCompatActivity {
    private ActivityProductAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
    }

    private void initListener() {
        binding.btAddProduct.setOnClickListener(v -> {
            String name = binding.etProductName.getText().toString();
            String price = binding.etProductPrice.getText().toString();
            String quantity = binding.etProductQuantity.getText().toString();
            if(!name.isEmpty() && !price.isEmpty() && !quantity.isEmpty()) {
                Double priceD = Double.valueOf(price);
                Integer quantityInt = Integer.valueOf(quantity);
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("price", priceD);
                intent.putExtra("quantity", quantityInt);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(this, "Please fill all edit text", Toast.LENGTH_SHORT).show();
            }
        });
    }
}