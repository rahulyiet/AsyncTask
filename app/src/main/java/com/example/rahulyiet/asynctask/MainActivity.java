package com.example.rahulyiet.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button imgbtn,toastbtn;
    ImageView imageView;
     ProgressBar progressBar;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn = findViewById(R.id.imgbtn);
        toastbtn = findViewById(R.id.toastbtn);

        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
        toastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "I am toast", Toast.LENGTH_SHORT).show();
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                   loadimage();
                new LoadIconTask().execute(R.drawable.pyar);
            }


        });

    }
        class LoadIconTask extends AsyncTask<Integer, Integer, Bitmap> {



            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressBar.setVisibility(ProgressBar.VISIBLE);
            }
            @Override
            protected Bitmap doInBackground(Integer... integers) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pyar);
                return bitmap;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setVisibility(ProgressBar.INVISIBLE);
               imageView.setImageBitmap(bitmap);

            }
        }
    }
//  private void loadimage() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.pyar);
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        }).start();
//    }

