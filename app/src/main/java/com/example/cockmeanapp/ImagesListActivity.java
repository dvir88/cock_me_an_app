package com.example.cockmeanapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ImagesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_list);

        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ImageAdapter(this, getImages()));


    }
    private List<Bitmap> getImages() {
        List<Bitmap> images = new ArrayList<>();

        // Get the list of all saved images from internal storage
        File directory = getFilesDir();
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".png")) {
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
                    images.add(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return images;

    }



}