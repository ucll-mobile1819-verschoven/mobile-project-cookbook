package com.ucll.cookbook.domain.db;

import com.ucll.cookbook.domain.model.Recipe;

import java.util.List;

public interface RecipeDB {
    Recipe get(int id);

    List<Recipe> getAll();

    void add(Recipe recipe);

    void update(Recipe recipe);

    void delete(int id);
}
