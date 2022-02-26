package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> n = new ArrayList<Word>();

        n.add(new Word("My","s",R.raw.taasir_n));
        n.add(new Word("s",R.raw.p2));
        n.add(new Word("s",R.raw.p3));
        n.add(new Word("s",R.raw.p4));
        n.add(new Word("s",R.raw.p5));
        n.add(new Word("s",R.raw.p6));
        n.add(new Word("s",R.raw.p7));
        n.add(new Word("s",R.raw.p8));
        n.add(new Word("s",R.raw.p9));
        n.add(new Word("se",R.raw.p10));
        n.add(new Word("st",R.raw.p11));
        n.add(new Word("sd",R.raw.p12));
        n.add(new Word("su",R.raw.p13));
        n.add(new Word("ss",R.raw.p14));
        n.add(new Word("se",R.raw.p15));
        n.add(new Word("sh",R.raw.p16));
        n.add(new Word("sd",R.raw.p17));
        n.add(new Word("s",R.raw.p18));


        //
        //WordAdapter w = new WordAdapter(this, n);
        PhraseAdapter p = new PhraseAdapter(this, n,R.color.phra);
        //ArrayAdapter<Word> j = new ArrayAdapter<Word>(this,R.layout.list_item,n);
        // LinearLayout l = (LinearLayout) findViewById(R.id.lin);
        ListView l = (ListView) findViewById(R.id.listp);
        l.setAdapter(p);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = n.get(position);
                releaseMediaPlayer();
                m = MediaPlayer.create(Phrases.this, word.getSid());
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
