package ch.kra.reciperealm.helper;

import ch.kra.reciperealm.dto.IngredientDto;
import ch.kra.reciperealm.dto.RecipeFullDto;
import ch.kra.reciperealm.model.Ingredient;
import ch.kra.reciperealm.model.Recipe;

import java.util.List;

public class TestHelper {

    public static Recipe getValidRecipe() {
        return new Recipe("RecipeWoIngredients", 4);
    }

    public static Recipe getValidRecipeWithIngredients() {
        Recipe recipe = new Recipe("RecipeWithIngredients", 2);
        Ingredient ingredient1 = getIngredient();
        ingredient1.setRecipe(recipe);

        Ingredient ingredient2 = getIngredient();
        ingredient2.setRecipe(recipe);

        List<Ingredient> ingredients = List.of(
                ingredient1,
                ingredient2
        );

        recipe.setIngredients(ingredients);
        return recipe;
    }

    public static RecipeFullDto getValidRecipeFullDto() {
        RecipeFullDto recipeFullDto = new RecipeFullDto();
        recipeFullDto.setName("RecipeWithIngredients");
        recipeFullDto.setNumberOfPeople(2L);

        IngredientDto ingredientDto1 = getIngredientDto();
        ingredientDto1.setRecipe(recipeFullDto);

        IngredientDto ingredientDto2 = getIngredientDto();
        ingredientDto2.setRecipe(recipeFullDto);

        recipeFullDto.setIngredients(List.of(
                ingredientDto1,
                ingredientDto2
        ));
        return recipeFullDto;
    }

    private static Ingredient getIngredient() {
        return new Ingredient("Ingredient", 100, "g");
    }

    private static IngredientDto getIngredientDto() {
        return new IngredientDto("Ingredient", 100.0, "g");
    }
}
