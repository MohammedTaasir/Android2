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
        fam.add(new Word("My","Lady",R.drawable.nus,R.raw.twooo));
        fam.add(new Word("both","met",R.drawable.lv,R.raw.three));
        fam.add(new Word("i","initiated",R.drawable.taasir,R.raw.four));
        fam.add(new Word("she","got impressed",R.drawable.nus,R.raw.five));
        fam.add(new Word("both","kissed",R.drawable.kiss,R.raw.six));
        fam.add(new Word("went","hotel",R.drawable.hot,R.raw.seve));
        fam.add(new Word("lost","virginity",R.drawable.vir,R.raw.eight));
        fam.add(new Word("intense","sex",R.drawable.sx,R.raw.ninja));
        fam.add(new Word("taasir","fruitwala",R.drawable.tog,R.raw.tanned));
        fam.add(new Word("MyLady","fruitwala",R.drawable.jaan,R.raw.tanned));

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