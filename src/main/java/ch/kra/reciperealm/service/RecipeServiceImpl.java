package ch.kra.reciperealm.service;

import ch.kra.reciperealm.dto.FullRecipeDto;
import ch.kra.reciperealm.exception.EntityNotFoundException;
import ch.kra.reciperealm.model.Ingredient;
import ch.kra.reciperealm.model.Recipe;
import ch.kra.reciperealm.repository.IngredientRepository;
import ch.kra.reciperealm.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    @Override
    public List<Recipe> getRecipes() {
        return (List<Recipe>)recipeRepository.findAll();
    }

    @Override
    public FullRecipeDto getRecipe(final Long id) {
        Recipe recipe =  recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Recipe.class));

        List<Ingredient> ingredients = ingredientService.getIngredientsByRecipeId(recipe.getId());

        return new FullRecipeDto(recipe.getId(), recipe.getName(), ingredients);
    }

    @Override
    public FullRecipeDto addRecipe(final FullRecipeDto recipeDto) {

        Recipe savedRecipe = recipeRepository.save(recipeDto.toRecipe());
        recipeDto.setIngredients(ingredientService.addIngredients(recipeDto.getIngredients()
                .stream()
                .map(ingredient -> {
                    ingredient.setRecipe(savedRecipe);
                    return ingredient;
                }).collect(Collectors.toList())
        ));
        recipeDto.setId(savedRecipe.getId());

        return recipeDto;
    }
}
