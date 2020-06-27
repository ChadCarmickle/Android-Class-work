package com.murach.listviewinclassproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


// Extending to base adaper
public class MyAdapter extends BaseAdapter {

    private LayoutInflater M_inflate; // used to populate lit

    private String[] Lbl_Names; // Names for characters
    private String[] Txt_Small_Words; // The post they make
    private int[] pics; // Their profile pic
    private int[] numbers; // Radnom number for each post

    // Converting it to MyAdapter
    public MyAdapter(Context context, String[] Lbl_Names, String[] Small_Words, int[] pics, int[] numbers) {
        this.Lbl_Names = Lbl_Names;
        this.Txt_Small_Words = Small_Words;
        this.pics = pics;
        this.numbers = numbers;

        this.M_inflate = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return Lbl_Names.length;
    }

    @Override
    public Object getItem(int position) {

        return Lbl_Names[position];
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myListItems = M_inflate.inflate(R.layout.my_list_name, null);

        // Creating objects that refer to the MyAdapter.java file

        ImageView imageView2 = myListItems.findViewById(R.id.imageView2);
        TextView Txt_Lbl_Names = myListItems.findViewById(R.id.Lbl_NameBox);
        TextView Txt = myListItems.findViewById(R.id.Txt_Small_Words);
        TextView txtNumber = myListItems.findViewById(R.id.txtNumber);

        // Setting the text

        imageView2.setImageResource(pics[position]);
        Txt_Lbl_Names.setText(Lbl_Names[position]);
        Txt.setText(Txt_Small_Words[position]);
        txtNumber.setText(numbers[position] + "");//quick way to convert anything to a string in java

        return myListItems;
    }
}
