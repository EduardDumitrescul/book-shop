package org.example.bookshopfx.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.Cookbook;

public class ViewCookbookModel {
    private Cookbook cookbook;
    private StringProperty skill = new SimpleStringProperty();
    private StringProperty recipes = new SimpleStringProperty();
    private StringProperty recipesTried = new SimpleStringProperty();

    public void setCookbook(Cookbook cookbook) {
        this.cookbook = cookbook;
        skill.set(cookbook.getSkillLevel());
        recipes.set(String.valueOf(cookbook.getNumberOfRecipes()));
        recipesTried.set(String.valueOf(cookbook.getNumberOfRecipesTried()));
    }

    public StringProperty skillProperty() {
        return skill;
    }

    public StringProperty recipesProperty() {
        return recipes;
    }

    public StringProperty recipesTriedProperty() {
        return recipesTried;
    }

    public Cookbook getCookbook() {
        return cookbook;
    }
}
