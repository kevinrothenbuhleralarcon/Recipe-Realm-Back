package ch.kra.reciperealm.service;

import ch.kra.reciperealm.dto.RecipeFullDto;
import ch.kra.reciperealm.dto.RecipeDto;
import ch.kra.reciperealm.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> getRecipes();
    RecipeFullDto getRecipe(Long id);
    RecipeFullDto addRecipe(RecipeFullDto recipeFullDto);
}
