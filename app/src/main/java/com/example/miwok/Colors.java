package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

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
        setContentView(R.layout.activity_colors);

        final ArrayList<Word> n = new ArrayList<Word>();

        n.add(new Word("taasir","fruitwala",R.drawable.color_red,R.raw.red));
        n.add(new Word("x","x",R.drawable.color_dusty_yellow,R.raw.yell));
        n.add(new Word("taasir","fruitwala",R.drawable.color_mustard_yellow,R.raw.yello));
        n.add(new Word("x","x",R.drawable.color_gray,R.raw.gray));
        n.add(new Word("taasir","fruitwala",R.drawable.color_green,R.raw.green));
        n.add(new Word("x","x",R.drawable.color_black,R.raw.black));
        n.add(new Word("taasir","fruitwala",R.drawable.color_brown,R.raw.brown));
        n.add(new Word("x","x",R.drawable.color_white,R.raw.white));



        //
        WordAdapter w = new WordAdapter(this, n,R.color.orr);
        //ArrayAdapter<Word> j = new ArrayAdapter<Word>(this,R.layout.list_item,n);
        // LinearLayout l = (LinearLayout) findViewById(R.id.lin);
        ListView l = (ListView) findViewById(R.id.listc);
        l.setAdapter(w);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = n.get(position);
                releaseMediaPlayer();
                m = MediaPlayer.create(Colors.this, word.getSid());
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
