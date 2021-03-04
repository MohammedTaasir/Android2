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

        n.add(new Word("My","Lady",R.raw.taasir_n));
        n.add(new Word("i love you","more than myself",R.raw.p2));
        n.add(new Word("i have worked on myself","just for you",R.raw.p3));
        n.add(new Word("this world is so devil","but god made someone for me who will love me forever",R.raw.p4));
        n.add(new Word("you are in my heart","i see myself in you",R.raw.p5));
        n.add(new Word("you are my focus","i don't wanna lose you",R.raw.p6));
        n.add(new Word("being with you","will only make me better day by day",R.raw.p7));
        n.add(new Word("dont care what others say","coz its our both life we will decide what we want",R.raw.p8));
        n.add(new Word("just kiss and carass me","i am forever yours",R.raw.p9));
        n.add(new Word("i have'nt got any head massage yet","i m sure you will give me",R.raw.p10));
        n.add(new Word("dont worry i will worship u","just say me what you want",R.raw.p11));
        n.add(new Word("if u will give me one","i will give you thousand",R.raw.p12));
        n.add(new Word("i do like food","as much as i love you",R.raw.p13));
        n.add(new Word("i do like abs","as much as my lips loves your lips",R.raw.p14));
        n.add(new Word("i do like playing sports","as much as my tongue loves your tongue",R.raw.p15));
        n.add(new Word("but short n sweet","i love nusrat shaikh",R.raw.p16));
        n.add(new Word("stay with me","make me feel blessed",R.raw.p17));
        n.add(new Word("my love with u won't end after sex","i swear on my dick",R.raw.p18));


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