package it.kyaw.myapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.kyaw.myapp.MusicPlayer.Data;


public class MusicListActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    //    private Button btnPlay, btnPause;
    private ImageView btn_back;
    static final List<Data> mySongs = List.of(
            new Data("Black Pink", R.drawable.images_p, R.raw.blackpink),
            new Data("Burno Mars", R.drawable.burnomrs, R.raw.burnomars),
            new Data("Justin Beiber", R.drawable.justinb, R.raw.justinbieber),
            new Data("Taylor Swift", R.drawable.tyls, R.raw.tyl),
            new Data("IVE", R.drawable.ive, R.raw.iveb));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(v -> {
            finish();;
        });


//        if (ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//        } else {
////            initializePlayer();
//        }

    }

    //    private void initializePlayer() {
//    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                initializePlayer();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void onSelectSong(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        if (view.getId() == R.id.cv_blackpink) {
            intent.putExtra("artist_index", 0);
            intent.putExtra("artist", mySongs.get(0));

        } else if (view.getId() == R.id.cv_burno) {
            intent.putExtra("artist", mySongs.get(1));
            intent.putExtra("artist_index", 1);

        } else if (view.getId() == R.id.cv_jbr) {
            intent.putExtra("artist", mySongs.get(2));
            intent.putExtra("artist_index", 2);
        }else if (view.getId() == R.id.cv_tls) {
            intent.putExtra("artist", mySongs.get(3));
            intent.putExtra("artist_index", 3);
        }else if (view.getId() == R.id.cv_ive) {
            intent.putExtra("artist", mySongs.get(4));
            intent.putExtra("artist_index", 4);
        }
        startActivity(intent);
    }

    private class READ_EXTERNAL_STORAGE {
    }
}