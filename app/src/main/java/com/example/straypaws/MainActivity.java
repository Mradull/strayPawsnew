package com.example.straypaws;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.straypaws.Adaptor.CategoryAdaptor;
import com.example.straypaws.Adaptor.PopularAdaptor;
import com.example.straypaws.Domain.CategoryDomain;
import com.example.straypaws.Domain.PopularDomain;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    private MeowBottomNavigation bottomNavigation;
    RelativeLayout setting,home,person;
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCateogory,recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.bottomNavigation);
        setting=findViewById(R.id.settings);
        home=findViewById(R.id.home);
        person=findViewById(R.id.person);
        bottomNavigation.show(2,true);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.baseline_settings_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.baseline_person_24));
        recyclerViewCateogory();
        recyclerViewPopular();

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (model.getId()){
                    case 1:
                        setting.setVisibility(View.VISIBLE);
                        home.setVisibility(View.GONE);
                        person.setVisibility(View.GONE);
                        break;
                    case 2:
                        setting.setVisibility(View.GONE);
                        home.setVisibility(View.VISIBLE);
                        person.setVisibility(View.GONE);
                        break;
                    case 3:
                        setting.setVisibility(View.GONE);
                        home.setVisibility(View.GONE);
                        person.setVisibility(View.VISIBLE);
                        break;
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (model.getId()) {
                    case 1:
                        setting.setVisibility(View.VISIBLE);
                        home.setVisibility(View.GONE);
                        person.setVisibility(View.GONE);
                        break;
                }
                return null;
            }
        });
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (model.getId()) {
                    case 2:
                        setting.setVisibility(View.GONE);
                        home.setVisibility(View.VISIBLE);
                        person.setVisibility(View.GONE);
                        break;
                }
                return null;
            }
        });
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (model.getId()) {
                    case 3:
                        setting.setVisibility(View.GONE);
                        home.setVisibility(View.GONE);
                        person.setVisibility(View.VISIBLE);
                        break;
                }
                return null;
            }
        });
    }

    private void recyclerViewCateogory() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCateogory = findViewById(R.id.category);
        recyclerViewCateogory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category= new ArrayList<>();
        category.add(new CategoryDomain("Adopt"));
        category.add(new CategoryDomain("Ngo"));
        category.add(new CategoryDomain("Volunteer"));
        category.add(new CategoryDomain("Donate"));

        adapter= new CategoryAdaptor((category));
        recyclerViewCateogory.setAdapter(adapter);
    }


    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopular = findViewById(R.id.popular);
        recyclerViewPopular.setLayoutManager(linearLayoutManager);
        ArrayList<PopularDomain> popular= new ArrayList<>();
        popular.add(new PopularDomain("Dog Food","pizza1","round circle ",1499.00));
        popular.add(new PopularDomain("Dog Food","pizza1","round circle ",1499.00));
        popular.add(new PopularDomain("Dog Food","pizza1","round circle ",1499.00));
        adapter2 = new PopularAdaptor((popular));
        recyclerViewPopular.setAdapter(adapter2);
    }
}