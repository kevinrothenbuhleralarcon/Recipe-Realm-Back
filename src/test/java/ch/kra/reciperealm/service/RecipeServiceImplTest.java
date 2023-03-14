package ch.kra.reciperealm.service;

import ch.kra.reciperealm.dto.RecipeDto;
import ch.kra.reciperealm.dto.RecipeFullDto;
import ch.kra.reciperealm.model.Recipe;
import ch.kra.reciperealm.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static ch.kra.reciperealm.helper.TestHelper.getValidRecipe;
import static ch.kra.reciperealm.helper.TestHelper.getValidRecipeFullDto;
import static ch.kra.reciperealm.helper.TestHelper.getValidRecipeWithIngredients;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RecipeServiceImplTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeServiceImpl recipeService;

    @Test
    public void getRecipesShouldReturnRecipeListWoIngredientsAndSteps() {
        /*
         * Given
         */
        Recipe recipe1 = getValidRecipeWithIngredients();
        Recipe recipe2 = getValidRecipe();

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);

        /*
         * When
         */
        List<RecipeDto> result = recipeService.getRecipes();

        /*
         * Then
         */
        assertEquals(2, result.size());
        assertEquals("RecipeWithIngredients", result.get(0).getName());
        assertEquals("RecipeWoIngredients", result.get(1).getName());
        assertEquals(2, result.get(0).getNumberOfPeople());
        assertEquals(4, result.get(1).getNumberOfPeople());
    }

    @Test
    public void getRecipeShouldReturnRecipeWithIngredientsAndSteps() {
        /*
         * Given
         */
        Recipe recipe1 = getValidRecipeWithIngredients();
        long id = recipeRepository.save(recipe1).getId();

        /*
         * When
         */
        RecipeFullDto recipeFullDto = recipeService.getRecipe(id);

        /*
         * Then
         */
        assertNotNull(recipeFullDto);
        assertEquals("RecipeWithIngredients", recipeFullDto.getName());
        assertEquals(2, recipeFullDto.getNumberOfPeople());
        assertEquals(2, recipeFullDto.getIngredients().size());
        assertEquals("Ingredient", recipeFullDto.getIngredients().get(0).getIngredient());
        assertEquals(100, recipeFullDto.getIngredients().get(1).getQuantity());
        assertEquals("g", recipeFullDto.getIngredients().get(1).getUom());
    }

    @Test
    public void testAddRecipeShouldCorrectlyAddIngredients() {
        /*
         * Given
         */
        RecipeFullDto recipeFullDto = getValidRecipeFullDto();

        /*
         * When
         */
        long id = recipeService.addRecipe(recipeFullDto).getId();
        RecipeFullDto result = recipeService.getRecipe(id);

        /*
         * Then
         */
        assertNotNull(result);
        assertEquals("RecipeWithIngredients", result.getName());
        assertEquals(2, result.getNumberOfPeople());
        assertEquals(2, result.getIngredients().size());
        assertEquals("Ingredient", result.getIngredients().get(0).getIngredient());
        assertEquals(100, result.getIngredients().get(1).getQuantity());
        assertEquals("g", result.getIngredients().get(1).getUom());
    }
}
