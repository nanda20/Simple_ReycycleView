package com.example.owner.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Gallery_Grid extends AppCompatActivity {
    public RecyclerView myRecyclerView;
    public RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView.Adapter mAdapter;

    List<Gallery> myGallery= new ArrayList<>();
    private Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_grid);
        myRecyclerView =(RecyclerView) findViewById(R.id.grid_layout);
        mLayoutManager = new GridLayoutManager(getBaseContext(),3);
        myRecyclerView.setLayoutManager(mLayoutManager);

        gallery = new Gallery(R.drawable.image1);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image2);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image3);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image4);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image5);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image1);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image2);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image3);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image4);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image5);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image1);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image2);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image3);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image4);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image5);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image1);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image2);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image3);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image4);
        myGallery.add(gallery);
        gallery = new Gallery(R.drawable.image5);
        myGallery.add(gallery);


        mAdapter = new GalleryAdapter(myGallery);
        myRecyclerView.setAdapter(mAdapter);


    }

    public class Gallery {
        public int imageSource;

        public Gallery(int immageSource) {
            this.imageSource = immageSource;
        }

        public int getImageSource() {
            return imageSource;
        }

        public void setImageSource(int imageSource) {
            this.imageSource = imageSource;
        }
    }


        public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
            List<Gallery> gallery;

            public GalleryAdapter(List<Gallery> gallery) {
                this.gallery = gallery;
            }

            @Override
            public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_grid, parent, false);
                return new ViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(GalleryAdapter.ViewHolder holder, int position) {
                Gallery gmail = gallery.get(position);
                holder.imageView.setImageResource(gmail.getImageSource());


            }

            @Override
            public int getItemCount() {
                return gallery.size();
            }

            public class ViewHolder extends RecyclerView.ViewHolder {
                public ImageView imageView;

                public ViewHolder(View itemView) {
                    super(itemView);
                    imageView = (ImageView) itemView.findViewById(R.id.panggon_foto);


                }
            }
        }
    }



