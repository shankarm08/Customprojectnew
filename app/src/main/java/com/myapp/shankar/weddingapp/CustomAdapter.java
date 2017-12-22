package com.myapp.shankar.weddingapp;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by shan on 11/7/2017.
 */

public class CustomAdapter extends PagerAdapter {


    private Activity activity;
    private Integer[] imagesArray;  //defining imagesarray
    private String[] namesArray;    //defining stringarray

  //constructor
    public CustomAdapter(Activity activity, Integer[] imagesArray, String[] namesArray){

        this.activity = activity;
        this.imagesArray = imagesArray;
        this.namesArray = namesArray;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = ((Activity)activity).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.swipe, container, false); //i have defined my imageview and textview in swipe
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView);
        imageView.setImageResource(imagesArray[position]);  //getting the position
        TextView textView1 = (TextView) viewItem.findViewById(R.id.textView);
        textView1.setText(namesArray[position]);
        ((ViewPager)container).addView(viewItem);

        return viewItem;  //returns the viewitem
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imagesArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub
        return view == ((View)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
}




