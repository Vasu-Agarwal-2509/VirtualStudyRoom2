package com.example.virtualstudyroom;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_second);


        rcv = (RecyclerView) findViewById(R.id.rcv1);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myadapter(dataqueue(), getApplicationContext());
        rcv.setAdapter(adapter);

    }

    public ArrayList<Model> dataqueue(){
        ArrayList<Model> holder = new ArrayList<>();
        Model ob1 = new Model();

        ob1.setHeader("C programming");
        ob1.setImgname(R.drawable.c);
        holder.add(ob1);

        Model ob2 = new Model();
        ob2.setHeader("C++ programming");
        ob2.setImgname(R.drawable.cplus);
        holder.add(ob2);

        Model ob3 = new Model();
        ob3.setHeader("JAVA programming");
        ob3.setImgname(R.drawable.java);
        holder.add(ob3);

        Model ob4 = new Model();
        ob4.setHeader("C# programming");
        ob4.setImgname(R.drawable.csharp);
        holder.add(ob4);

        Model ob5 = new Model();
        ob5.setHeader("Kotlin programming");
        ob5.setImgname(R.drawable.kotlin);
        holder.add(ob5);

        Model ob6 = new Model();
        ob6.setHeader("C++ programming");
        ob6.setImgname(R.drawable.cplus);
        holder.add(ob6);

        Model ob7 = new Model();
        ob7.setHeader("SQL programming");
        ob7.setImgname(R.drawable.sql);
        holder.add(ob7);

        Model ob8 = new Model();
        ob8.setHeader("PHP programming");
        ob8.setImgname(R.drawable.php);
        holder.add(ob8);

        Model ob9 = new Model();
        ob9.setHeader("Python programming");
        ob9.setImgname(R.drawable.python);
        holder.add(ob9);

        return holder;
    }
}