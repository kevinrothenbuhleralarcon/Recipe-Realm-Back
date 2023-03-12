package ch.kra.reciperealm.service;

import ch.kra.reciperealm.dto.FullRecipeDto;
import ch.kra.reciperealm.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes();
    FullRecipeDto getRecipe(Long id);
    FullRecipeDto addRecipe(FullRecipeDto recipeDto);
}
