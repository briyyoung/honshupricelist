package com.example.brianyoung.testing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;
import java.util.ArrayList;


    /**
     * Created by User on 3/14/2017.
     */

    public class PersonListAdapter extends ArrayAdapter<Person> {

        private static final String TAG = "PersonListAdapter";

        private Context mContext;
        private int mResource;
        private int lastPosition = -1;

        /**
         * Holds variables in a View
         */
        private static class ViewHolder {
            TextView name;
            TextView birthday;
            TextView sex;
            ImageView img;
        }

        /**
         * Default constructor for the PersonListAdapter
         * @param context
         * @param resource
         * @param objects
         */
        public PersonListAdapter(Context context, int resource, ArrayList<Person> objects) {
            super(context, resource, objects);
            mContext = context;
            mResource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //set up image loader
            setUpImageLoader();
            //get the persons information
            String name = getItem(position).getName();
            String birthday = getItem(position).getBirthday();
            String sex = getItem(position).getSex();
            String imgUrl = getItem(position).getImgUrl();

            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            ViewHolder holder;


            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.textView1);
                holder.birthday = (TextView) convertView.findViewById(R.id.textView2);
                holder.sex = (TextView) convertView.findViewById(R.id.textView3);
                holder.img = (ImageView) convertView.findViewById(R.id.image);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }


            Animation animation = AnimationUtils.loadAnimation(mContext,
                    (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
            result.startAnimation(animation);
            lastPosition = position;


            ImageLoader imageLoader = ImageLoader.getInstance();

            int defaultImage = mContext.getResources().getIdentifier("http://honshu.co.id/file/dekorasi/headerlogo.png",null, mContext.getPackageName());

            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();

            imageLoader.displayImage(imgUrl, holder.img, options);

            holder.name.setText(name);
            holder.birthday.setText(birthday);
            holder.sex.setText(sex);


            return convertView;
        }

        private void setUpImageLoader(){
            // UNIVERSAL IMAGE LOADER SETUP
            DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                    .cacheOnDisc(true).cacheInMemory(true)
                    .imageScaleType(ImageScaleType.EXACTLY)
                    .displayer(new FadeInBitmapDisplayer(300)).build();

            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mContext)
                    .defaultDisplayImageOptions(defaultOptions)
                    .memoryCache(new WeakMemoryCache())
                    .discCacheSize(100 * 1024 * 1024).build();

            ImageLoader.getInstance().init(config);
            // END - UNIVERSAL IMAGE LOADER SETUP
        }
    }
