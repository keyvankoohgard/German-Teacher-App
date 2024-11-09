package com.example.germanteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button blackBtn, redBtn, yellowBtn, purpleBtn, greenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        redBtn = findViewById(R.id.redBtn);
        blackBtn = findViewById(R.id.blackBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        greenBtn = findViewById(R.id.greenBtn);

        redBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // find the view by ID and play the correct sound
        int clickedBtnId = v.getId();
        if (clickedBtnId == R.id.redBtn){
            PlaySounds(R.raw.rot);
        } else if (clickedBtnId == R.id.blackBtn) {
            PlaySounds(R.raw.schwarz);
        } else if (clickedBtnId == R.id.greenBtn) {
            PlaySounds(R.raw.grun);
        } else if (clickedBtnId == R.id.purpleBtn) {
            PlaySounds(R.raw.lila);
        } else if (clickedBtnId == R.id.yellowBtn) {
            PlaySounds(R.raw.gelb);
        }

    }
    public void PlaySounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
        // Release the MediaPlayer resource after the sound has finished playing
        mediaPlayer.setOnCompletionListener(mp -> {
            mp.release();
        });
    }
}