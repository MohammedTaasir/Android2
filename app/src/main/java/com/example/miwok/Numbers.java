package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Numbers extends AppCompatActivity {
    private MediaPlayer m;
    private MediaPlayer.OnCompletionListener moc = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager am;
    private AudioManager.OnAudioFocusChangeListener ac = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                m.pause();
                m.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                m.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);



        final ArrayList<Word> n = new ArrayList<Word>();

        n.add(new Word("taasir","fruitwala",R.drawable.number_one,R.raw.taasir_n));
        n.add(new Word("taasir","fruitwala",R.drawable.number_two,R.raw.taasir_n));
        n.add(new Word("taasir","fruitwala",R.drawable.number_three,R.raw.taasir_n));
        n.add(new Word("taasir","fruitwala",R.drawable.number_four,R.raw.taasir_n));
        n.add(new Word("taasir","fruitwala",R.drawable.number_five,R.raw.taasir_n));
        n.add(new Word("My","Lady",R.drawable.number_six,R.raw.my));
        n.add(new Word("My","Lady",R.drawable.number_seven,R.raw.my));
        n.add(new Word("My","Lady",R.drawable.number_eight,R.raw.my));
        n.add(new Word("My","Lady",R.drawable.number_nine,R.raw.my));
        n.add(new Word("My","Lady",R.drawable.number_ten,R.raw.my));







        //
        WordAdapter w = new WordAdapter(this, n,R.color.pinn);
        //ArrayAdapter<Word> j = new ArrayAdapter<Word>(this,R.layout.list_item,n);
       // LinearLayout l = (LinearLayout) findViewById(R.id.lin);
        ListView l = (ListView) findViewById(R.id.list);
        l.setAdapter(w);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = n.get(position);
                releaseMediaPlayer();//------------------>JUST for safety purpose so that no two voices can overlap

                int result = am.requestAudioFocus(ac, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    m = MediaPlayer.create(Numbers.this, word.getSid());
                    m.start();
                    m.setOnCompletionListener(moc);

                }


            }
        });



    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){//----------->this METHOD is global use it anywhere
        if(m!=null){
            m.release();
            m=null;
            am.abandonAudioFocus(ac);
        }
    }
}