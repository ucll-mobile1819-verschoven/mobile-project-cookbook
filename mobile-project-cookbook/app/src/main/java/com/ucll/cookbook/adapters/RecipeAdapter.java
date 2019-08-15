package com.ucll.cookbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ucll.cookbook.domain.model.Recipe;
import com.ucll.cookbook.R;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    private static class ViewHolder {
        public TextView tvTitle;
        public TextView tvAuthor;
    }

    public RecipeAdapter(Context context, ArrayList<Recipe> aRecipes) {
        super(context, 0, aRecipes);
    }

    // Translates a particular `Book` given a position
    // into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Recipe recipe = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_recipe, parent, false);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.tvAuthor);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(recipe.getName());
        viewHolder.tvAuthor.setText(recipe.getDescription());
        // Return the completed view to render on screen
        return convertView;
    }
}
