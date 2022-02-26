package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

    private MediaPlayer m;
    private MediaPlayer.OnCompletionListener moc = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<Word> fam = new ArrayList<Word>();
        fam.add(new Word("taasir","fruitwala",R.drawable.taasir,R.raw.one));
        fam.add(new Word("My","x",R.drawable.nus,R.raw.twooo));
        fam.add(new Word("x","x",R.drawable.lv,R.raw.three));
        fam.add(new Word("i","x",R.drawable.taasir,R.raw.four));
        fam.add(new Word("x","x x",R.drawable.nus,R.raw.five));
        fam.add(new Word("x","x",R.drawable.x,R.raw.six));
        fam.add(new Word("x","x",R.drawable.x,R.raw.seve));
        fam.add(new Word("x","x",R.drawable.x,R.raw.eight));
        fam.add(new Word("x","x",R.drawable.x,R.raw.ninja));
        fam.add(new Word("x","x",R.drawable.x,R.raw.tanned));
        fam.add(new Word("x","x",R.drawable.x,R.raw.tanned));

        WordAdapter w = new WordAdapter(this, fam,R.color.nusrat);
        ListView l = (ListView) findViewById(R.id.listf);
        l.setAdapter(w);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = fam.get(position);
                releaseMediaPlayer();
                m = MediaPlayer.create(Family.this, word.getSid());
                m.start();
                m.setOnCompletionListener(moc);
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
        }
    }
}
