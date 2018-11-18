package com.meal.mealapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecipiesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Recipie> recipiesList;
    private RecipiesAdapter mAdapter;
    private android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recipies);
        recyclerView = findViewById(R.id.recyclerViewRecipies);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // what do you want here
                finish();
            }
        });


        recipiesList = new ArrayList<>();

        mAdapter = new RecipiesAdapter(this, recipiesList);


        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    public void prepareData() {
        // Get From Database
        Recipie r = new Recipie("Nasi Ayam Broccoli");
        recipiesList.add(r);


        mAdapter.notifyDataSetChanged();
    }








    class RecipiesAdapter extends RecyclerView.Adapter<RecipiesAdapter.MyViewHolder> {
        private Context context;
        private List<Recipie> recipieList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView name;
            public CardView card;

            public MyViewHolder(View view) {
                super(view);
                name = view.findViewById(R.id.recipeName);
                card = view.findViewById(R.id.recipeCard);
            }
        }

        public RecipiesAdapter(Context context, List<Recipie> recipieList) {
            this.context = context;
            this.recipieList = recipieList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipies, parent, false);
            return new RecipiesAdapter.MyViewHolder(ItemView);
        }

        @Override
        public void onBindViewHolder(RecipiesAdapter.MyViewHolder holder, int position) {
            Recipie recipie = recipieList.get(position);
            holder.name.setText(recipie.getName());

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


        }

        public int getItemCount() {
            return recipieList.size();
        }

    }
}
