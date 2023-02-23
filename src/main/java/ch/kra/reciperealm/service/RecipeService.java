package ch.kra.reciperealm.service;

import ch.kra.reciperealm.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes();
    Recipe getRecipe(Long id);
    Recipe addRecipe(Recipe recipe);
}
