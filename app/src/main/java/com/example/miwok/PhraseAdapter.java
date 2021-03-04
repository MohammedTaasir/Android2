package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class PhraseAdapter extends ArrayAdapter<Word> {

    private int imgg;

    public PhraseAdapter(Activity context, ArrayList<Word> words, int im) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);//as usual first arg is of context, and for 2nd arg we dont want simple_list_item_1 which is provided by android we want to make our own view, and 3rd arg is of the list that we are having
        imgg=im;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {//we have to modify view method of arrayadapter so we are overriding here
        //return super.getView(position, convertView, parent);


        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(//at first it will be null so we will design the initial view here using list_item.xml
                    R.layout.phrase_item, parent, false);
        }



        Word currentWord = getItem(position);//we will get current word here

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.w1);//listitemview is connected to list_item.xml so we will find w1 from there and will assign word using setText()
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getMiwok());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView surnameTextView = (TextView) listItemView.findViewById(R.id.w2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        surnameTextView.setText(currentWord.getEnglish());

       // ImageView imag = (ImageView) listItemView.findViewById(R.id.img);
        //imag.setImageResource(currentWord.getImgId());

        View v = listItemView.findViewById(R.id.linear);
        int color= ContextCompat.getColor(getContext(), imgg);
        v.setBackgroundColor(color);

        return listItemView;//now at the end we will get one container which is designed using list_item.xml layout --> listItemView
    }




}
