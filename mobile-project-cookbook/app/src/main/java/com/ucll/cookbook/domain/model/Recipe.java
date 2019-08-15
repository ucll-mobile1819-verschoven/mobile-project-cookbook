package com.ucll.cookbook.domain.model;

public class Recipe {
    private int ID;
    private String name;
    private String description;

    public Recipe(){}

    public Recipe(int recipeID, String name, String description) {
        this.ID = recipeID;
        this.name = name;
        this.description = description;
    }

    public int getRecipeID() {
        return ID;
    }

    public void setRecipeID(int recipeID) {
        this.ID = recipeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
