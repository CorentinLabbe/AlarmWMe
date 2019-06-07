package com.example.alarmwme.view;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alarmwme.R;
import com.example.alarmwme.model.Food;


import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Food> values;
    private Intent secondActivity;
    private MainActivity mainActivity;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    //Comprendre ViewHolder == CELLULE
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, Food item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(List<Food> values, MainActivity mainActivity) {
        this.values = values;
        this.mainActivity = mainActivity;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    private static final String SelectedFood = "Le Whisky est en approche";
    public void SecondActivity(int position)
    {
        Intent secondActivity = new Intent(mainActivity, SecondActivity.class);
        final Food selectedFood = values.get(position);

        ArrayList<String> FoodDev = new ArrayList<>();
        FoodDev.add(selectedFood.getRegion());
        FoodDev.add(selectedFood.getPrice());
        FoodDev.add(selectedFood.getRating());

        secondActivity.putStringArrayListExtra(SelectedFood, FoodDev);

        mainActivity.startActivity(secondActivity);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Food selectedFood = values.get(position);
        holder.txtHeader.setText(selectedFood.getName());
        holder.layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity(position);
            }
        });

        holder.txtFooter.setText("URL : " + selectedFood.getUrl());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
