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
    private RecipiesActivity.RecipiesAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ingredients);
        recyclerView = findViewById(R.id.recyclerViewInventory);


        recipiesList = new ArrayList<>();

        mAdapter = new RecipiesActivity.RecipiesAdapter(this, recipiesList);


        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    public void prepareData() {
        // Get From Database


        mAdapter.notifyDataSetChanged();
    }




    class RecipiesAdapter extends RecyclerView.Adapter<RecipiesActivity.RecipiesAdapter.MyViewHolder> {
        private Context context;
        private List<Recipie> recipiesList;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView name;
            CardView recipeCard;

            public MyViewHolder(View view) {
                super(view);

                name = findViewById(R.id.recipeName);
                recipeCard = findViewById(R.id.recipeCard);

            }
        }

        // Adapter

        public RecipiesAdapter(Context context, List<Recipie> recipiesList) {
            this.context = context;
            this.recipiesList = recipiesList;
        }

        @Override
        public RecipiesActivity.RecipiesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe, parent, false);
            return new RecipiesActivity.RecipiesAdapter.MyViewHolder(ItemView);
        }

        @Override
        public void onBindViewHolder(RecipiesActivity.RecipiesAdapter.MyViewHolder holder, int position) {
            Recipie recipie = recipiesList.get(position);
            holder.name.setText(recipie.getName());

            // restock product click listener
            holder.recipeCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

        public int getItemCount() {
            return recipiesList.size();
        }
    }
}
