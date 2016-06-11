package com.example.miaha_000.myapplication;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by miaha_000 on 2016-06-11.
 */

public class ImageFragment extends Fragment implements View.OnClickListener{

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      myView = inflater.inflate(R.layout.image_layout, container, false);

        Button button = (Button) myView.findViewById(R.id.imageButton);
        button.setOnClickListener(this);



        return myView;
    }
    public void onClick(View v){

        String[] urlHolder = new String[]{ "http://www.su.se/img/logo_su_se_big_dark_blue.gif",
                "https://scontent.cdninstagram.com/hphotos-xaf1/l/t51.2885-15/s150x150/e15/11055499_891200084275984_375609334_n.jpg",
                "https://support.cdn.mozilla.net/static/sumo/img/blank.png",
                "http://www-cs-faculty.stanford.edu/~uno/organ.jpeg"
        };
        ImageView img1 = (ImageView) v.findViewById(R.id.img1);
        ImageView img2 = (ImageView) v.findViewById(R.id.img2);
        ImageView img3 = (ImageView) v.findViewById(R.id.img3);
        ImageView img4 = (ImageView) v.findViewById(R.id.img4);

        for (int i = 0; i < urlHolder.length ; i++){
            if(i == 0){
                new LoadImages(img1)
                        .execute(urlHolder[0]);
            }else if(i == 1){
                new LoadImages(img2)
                        .execute(urlHolder[1]);
            }else if (i == 2){
                new LoadImages(img3)
                        .execute(urlHolder[2]);
            }else if (i == 3){
                new LoadImages(img4)
                        .execute(urlHolder[3]);
            }else{
                Toast.makeText(getActivity(), "Error is happening", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public class LoadImages extends AsyncTask<String, Void, Bitmap>{
        ImageView img;
        Bitmap bitmap;

        public LoadImages(ImageView img) {
            this.img = img;
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(image != null){
                if (image != null){
                    if (img != null){
                        img.setImageBitmap(image);
                    }else{
                        Toast.makeText(getActivity(), "can't access ImageView...", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Could't load images from url", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(getActivity(), "Something went wrong when loading images", Toast.LENGTH_SHORT).show();

            }
        }

    }

}
