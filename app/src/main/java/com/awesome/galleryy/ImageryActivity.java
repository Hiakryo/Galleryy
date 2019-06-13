package com.awesome.galleryy;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageryActivity extends AppCompatActivity {
    ImageView Imagefullview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagery);
        Imagefullview=(ImageView) findViewById(R.id.fullimageviewer);
        String x = getIntent().getExtras().getString("img");
        Imagefullview.setImageURI(Uri.parse(x));
    }
}
