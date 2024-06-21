package it.kyaw.myapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import it.kyaw.myapp.Adapter.AppClickListener;
import it.kyaw.myapp.Adapter.AppData;
import it.kyaw.myapp.Adapter.MainAdapter;
import it.kyaw.myapp.Voucher.Voucher;
import it.kyaw.myapp.databinding.ActivityAllAppBinding;


public class AllApp extends AppCompatActivity {

    private ActivityAllAppBinding binding;
    private MainAdapter mainAdapter;

    AppData[] appData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllAppBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        initUI();
        initListeners();

    }

    private void initData() {
        appData = new AppData[]
        {
                new AppData("Guess Word", R.drawable.guess_word, new Intent(this, GuessWord.class)),
                new AppData("Font Converter", R.drawable.ic_fontconverter, new Intent(this, FontConverter.class)),
                new AppData("Calculator", R.drawable.ic_calculator, new Intent(this, Calculator.class)),
                new AppData("Dice Roller", R.drawable.ic_die, new Intent(this, DiceRoller.class)),
                new AppData("Date Counter", R.drawable.ic_datecounter, new Intent(this, DateCounter.class)),
                new AppData("Voucher", R.drawable.ic_voucher, new Intent(this, Voucher.class)),
                new AppData("Musuic Player", R.drawable.ic_music, new Intent(this, MusicListActivity.class)),
                new AppData("Guess Word", R.drawable.guess_word, new Intent(this, GuessWord.class)),
                new AppData("Font Converter", R.drawable.ic_fontconverter, new Intent(this, FontConverter.class)),
                new AppData("Calculator", R.drawable.ic_calculator, new Intent(this, Calculator.class)),
                new AppData("Dice Roller", R.drawable.ic_die, new Intent(this, DiceRoller.class)),
                new AppData("Date Counter", R.drawable.ic_datecounter, new Intent(this, DateCounter.class)),
                new AppData("Voucher", R.drawable.ic_voucher, new Intent(this, Voucher.class))
        };

    }

    private void initListeners() {
        mainAdapter.setAppClickListener(new AppClickListener() {
            @Override
            public void onClick(int index) {
                AppData data = appData[index];
                Intent intent = data.intent();
                if(intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void initUI() {

        mainAdapter = new MainAdapter();
        mainAdapter.setAppDatas(List.of(appData));

        binding.rvAllapp.setAdapter(mainAdapter);
        binding.rvAllapp.setLayoutManager(new LinearLayoutManager(this));
    }


}