package ch.kra.reciperealm.service;

import ch.kra.reciperealm.exception.EntityNotFoundException;
import ch.kra.reciperealm.model.Recipe;
import ch.kra.reciperealm.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getRecipes() {
        return (List<Recipe>)recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipe(final Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Recipe.class));
    }

    @Override
    public Recipe addRecipe(final Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
