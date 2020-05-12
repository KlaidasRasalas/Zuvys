package com.example.zuvys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import static android.R.id.list;

public class Nuotrauka extends AppCompatActivity
{

    private int PICK_IMAGE_REQUEST = 1;


    private static final int INPUT_SIZE = 299;
    private static final int IMAGE_MEAN = 128;
    private static final float IMAGE_STD = 128;
    public static final String INPUT_NAME = "Mul";
    public static final String OUTPUT_NAME = "final_result";
    public static final String MODEL_FILE = "file:///android_asset/stripped_graph.pb";
    public static final String LABEL_FILE = "file:///android_asset/retrained_labels.txt";

    public Classifier classifier;
    public Executor executor = Executors.newSingleThreadExecutor();
    public TextView TV1;
    public ImageView iV1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nuotrauka);
        TV1 = (TextView) findViewById(R.id.textView1);
        iV1 = (ImageView) findViewById(R.id.imageView1);
        initTensorFlowAndLoadModel();

    }
    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_FILE,
                            LABEL_FILE,
                            INPUT_SIZE,
                            IMAGE_MEAN,
                            IMAGE_STD,
                            INPUT_NAME,
                            OUTPUT_NAME);
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }

    public List<Classifier.Recognition> analyse(Bitmap bitmap)
    {
        bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
        final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
        return results;
    }

    public void selectPhoto(View v)
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try
            {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                setPicture(selectedImage);
                List<Classifier.Recognition> results = analyse(selectedImage);
                TV1.setText(results.get(0).toString());


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPicture(Bitmap bp)
    {
        Bitmap scaledBp =  Bitmap.createScaledBitmap(bp, iV1.getWidth(), iV1.getHeight(), false);
        iV1.setImageBitmap(scaledBp);
    }

}