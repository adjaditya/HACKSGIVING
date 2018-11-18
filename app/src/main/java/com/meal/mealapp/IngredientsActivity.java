package com.meal.mealapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import java.util.ArrayList;


public class IngredientsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button restockAllBtn;
    private List<Ingredient> ingredientList;
    private IngredientAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ingredients);
        recyclerView = findViewById(R.id.recyclerViewInventory);
        restockAllBtn = findViewById(R.id.restockAllBtn);

        ingredientList = new ArrayList<>();

        mAdapter = new IngredientAdapter(this, ingredientList);


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




    class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.MyViewHolder> {
        private Context context;
        private List<Ingredient> ingredientsList;

        public class MyViewHolder extends RecyclerView.ViewHolder {

            public TextView units, name, quantity, calories;
            public Button restock, edit;

            public MyViewHolder(View view) {
                super(view);
                units = view.findViewById(R.id.units);
                name = view.findViewById(R.id.ingredientName);
                quantity = view.findViewById(R.id.quantityAmt);
                calories = view.findViewById(R.id.caloriesAmt);
                restock = view.findViewById(R.id.restockBtn);
                edit = view.findViewById(R.id.editBtn);
            }
        }

        // Adapter

        public IngredientAdapter(Context context, List<Ingredient> ingredientsList) {
            this.context = context;
            this.ingredientsList = ingredientsList;
        }

        @Override
        public IngredientAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_inventory, parent, false);
            return new IngredientAdapter.MyViewHolder(ItemView);
        }

        @Override
        public void onBindViewHolder(IngredientAdapter.MyViewHolder holder, int position) {
            Ingredient ingredient = ingredientList.get(position);
            holder.units.setText(ingredient.getUnits());
            holder.name.setText(ingredient.getName());
            holder.quantity.setText(Double.toString(ingredient.getQuantitiy()));
            holder.calories.setText(ingredient.getCalories());

            // restock product click listener
            holder.restock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            // edit quantity click listener
            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


        }

        public int getItemCount() {
            return ingredientList.size();
        }
    }


}


