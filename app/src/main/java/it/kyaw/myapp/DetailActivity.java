package it.kyaw.myapp;


import static it.kyaw.myapp.MusicListActivity.mySongs;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.RawResourceDataSource;
import androidx.media3.exoplayer.ExoPlayer;

import it.kyaw.myapp.MusicPlayer.Data;


public class DetailActivity extends AppCompatActivity {

    private TextView tvArtist;
    private ImageView ivArtist;
    private ImageView btPrev, btPause, btNext, back_btn, menu_btn, shuffle_btn, repeat_btn;

    private int artistIndex;
    private Data data;

    private static ExoPlayer exoPlayer;

    SeekBar musicSeekBar;

    private TextView elapsedTimeLabel;
//    private TextView totalTimeLabel;

//        private ExoPlayer exoPlayer;
    private Handler handler = new Handler();
    private Runnable runnable;

//    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initDataFromIntent();
        initUii();
        initPlayer();
        initListeners();
        musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    exoPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });


        musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (exoPlayer != null && fromUser) {
                    exoPlayer.seekTo(progress * 100);
                }
                if(fromUser) {
                    exoPlayer.seekTo(progress);
//                    updateSeekBar();
                }
//                    exoPlayer.setProgress(progress);
//updateSeekBar();}

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        DetailActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (exoPlayer != null) {
                    int mCurrentPosition = (int) (exoPlayer.getCurrentPosition() / 1000);
                    musicSeekBar.setProgress(mCurrentPosition);
                    elapsedTimeLabel.setText(formattedTime(mCurrentPosition));
//                    updateSeekBar();
//                    updatePlayer();
                }
                handler.postDelayed(this, 1000);
            }
        });


    }


    private void initDataFromIntent() {
        if (getIntent() != null) {
            artistIndex = getIntent().getIntExtra("artist_index", 0);
            data = (Data) getIntent().getSerializableExtra("artist");
//            updateSeekBar();
//            updatePlayer();
        }
    }

    private void initListeners() {

        btNext.setOnClickListener(v -> {
            if (artistIndex == mySongs.size() - 1) {
                artistIndex = 0;
            } else {
                artistIndex++;
            }
            data = mySongs.get(artistIndex);
            btPause.setImageResource(R.drawable.ic_pause);
            updatePlayer();
        });

        btPrev.setOnClickListener(v -> {
            if (artistIndex == 0) {
                artistIndex = mySongs.size() - 1;
            } else {
                artistIndex--;
            }
            data = mySongs.get(artistIndex);
            btPause.setImageResource(R.drawable.ic_pause);
            updatePlayer();
            updateSeekBar();
        });
        btPause.setOnClickListener(v -> {
            if (exoPlayer.isPlaying()) {
                exoPlayer.pause();
                btPause.setImageResource(R.drawable.ic_play);
                updateSeekBar();
            } else {
                exoPlayer.play();
                btPause.setImageResource(R.drawable.ic_pause);
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, " Menu Onclicked", Toast.LENGTH_SHORT).show();
            }
        });
        shuffle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, " Shuffle Onclicked", Toast.LENGTH_SHORT).show();
            }
        });
        repeat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, " repeat_btn Onclicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String formattedTime(int mCurrentPosition) {
        String totalout = "";
        String totalNew = "";
        String seconds = String.valueOf(mCurrentPosition % 60);
        String minutes = String.valueOf(mCurrentPosition / 60);
        totalout = minutes + ":" + seconds;
        totalNew = minutes + ":" + "0" + seconds;
        if (seconds.length() == 1) {
            return totalNew;
        } else {
            return totalout;
        }


    }


    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
            exoPlayer = null;
        }
        handler.removeCallbacks(runnable);
    }


    private void initPlayer() {

        if (exoPlayer == null)
            exoPlayer = new ExoPlayer.Builder(this).build();
        updatePlayer();
        updateSeekBar();

    }


    @OptIn(markerClass = UnstableApi.class)
    private void updatePlayer() {
        tvArtist.setText(data.artistName());
        ivArtist.setImageResource(data.artistPhoto());
        Uri song = RawResourceDataSource.buildRawResourceUri(data.artistSong());

        exoPlayer.setMediaItem(MediaItem.fromUri(song));
        exoPlayer.prepare();
        exoPlayer.play();
//        updateSeekBar();
    }

    private void updateSeekBar() {
        musicSeekBar.setProgress(Math.toIntExact(exoPlayer.getCurrentPosition()));
        if (exoPlayer.isPlaying()) {
            handler.postDelayed(this::updateSeekBar, 1000);

        }
    }

    private void initUii () {
        tvArtist = findViewById(R.id.tv_artist);
        ivArtist = findViewById(R.id.iv_artist);
        btNext = findViewById(R.id.bt_next);
        btPause = findViewById(R.id.bt_pause);
        btPrev = findViewById(R.id.bt_previous);
        musicSeekBar = findViewById(R.id.musicSeekBar);
        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel);
        back_btn = findViewById(R.id.back_btn);
        menu_btn = findViewById(R.id.menu_btn);
        shuffle_btn = findViewById(R.id.shuffle_btn);
        repeat_btn = findViewById(R.id.repeat_btn);
        btPause.setImageResource(R.drawable.ic_pause);

    }


}

