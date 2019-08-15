package com.ucll.cookbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeDBInMemory implements RecipeDB {
    private Map<Integer, Recipe> records = new HashMap<Integer, Recipe>();

    public RecipeDBInMemory(){
        Recipe r1 = new Recipe(1, "Lasagne", "Beschrijving van Lasagne");
        add(r1);
    }

    @Override
    public Recipe get(int id) {
        if (id < 0) {
            throw new DbException("No valid id given");
        }
        return records.get(id);
    }

    @Override
    public List<Recipe> getAll() {
        return new ArrayList<Recipe>(records.values());
    }

    @Override
    public void add(Recipe recipe) {
        if (recipe == null) {
            throw new DbException("No recipe given");
        }
        recipe.setRecipeID(records.size()+1);
        if (records.containsKey(recipe.getRecipeID())) {
            throw new DbException("Recipe already exists");
        }
        records.put(recipe.getRecipeID(), recipe);

    }

    @Override
    public void update(Recipe recipe) {
        if (recipe == null) {
            throw new DbException("No recipe given");
        }
        if (!records.containsKey(recipe.getRecipeID())) {
            throw new DbException("No recipe found");
        }
        records.put(recipe.getRecipeID(), recipe);

    }

    @Override
    public void delete(int id) {
        if (id < 0) {
            throw new DbException("No valid id given");
        }
        records.remove(id);

    }
}
