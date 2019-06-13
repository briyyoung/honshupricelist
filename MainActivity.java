package com.example.brianyoung.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        Person john = new Person("Honshu HSM93","AC Portable 1 pk","Rp 3.550.000", "http://honshu.co.id/file/catalog/small/66-gambar-ac-portable-hsm-93-2-copy.png");
        Person steve = new Person("Honshu HSAC91","Air Curtain 90cm","Rp 2.050.000", "http://honshu.co.id/file/catalog/small/HSAC91.png");
        Person steven = new Person("Honshu HSAC121","Air Curtain 120cm","Rp 2.150.000", "http://www.honshu.co.id/file/catalog/small/HSAC121.png");
        Person stacy = new Person("Honshu HSF252","AC Standing Floor 3pk","Rp 9.099.000", "http://honshu.co.id/file/catalog/small/HSF252.png");
        Person sts = new Person("Honshu HSF452","AC Standing Floor 5pk","Rp 15.250.000", "http://honshu.co.id/file/catalog/small/HSF252.png");
        Person ashley = new Person("Honshu HSD6006","AC Split 1/2pk","Rp 2.450.000", "http://honshu.co.id/file/catalog/small/HSD6006.png");
        Person max = new Person("Honshu HSAC88","Air Cooler Small","Rp 1.050.000", "http://www.honshu.co.id/file/catalog/small/HSAC88.png");
        Person matt = new Person("Honshu HSAC98","Air Cooler Medium","Rp 1.250.000", "http://honshu.co.id/file/catalog/small/HSAC98.png");
        Person tt = new Person("Honshu HSAC99","Air Cooler Large","Rp 3.699.000", "http://www.honshu.co.id/file/catalog/small/HSAC99.png");
        Person ben  = new Person("Honshu HSCS 252","AC Cassette 3pk","Rp 10.500.000", "http://www.honshu.co.id/file/catalog/small/HSCS252.png");
        Person bn  = new Person("Honshu HSCFS 252","AC Ceiling Suspended 3pk","Rp 11.000.000", "http://www.honshu.co.id/file/catalog/small/HSFS252.png");


        //Add the Person objects to an ArrayList
        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(john);
        peopleList.add(steve);
        peopleList.add(steven);
        peopleList.add(stacy);
        peopleList.add(sts);
        peopleList.add(ashley);
        peopleList.add(max);
        peopleList.add(matt);
        peopleList.add(tt);
        peopleList.add(ben);
        peopleList.add(bn);



        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }
}
