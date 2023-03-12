package ch.kra.reciperealm.service;

import ch.kra.reciperealm.model.Ingredient;
import ch.kra.reciperealm.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> addIngredients(List<Ingredient> ingredients) {
        return (List<Ingredient>)ingredientRepository.saveAll(ingredients);
    }

    @Override
    public List<Ingredient> getIngredientsByRecipeId(Long recipeId) {
        return ingredientRepository.findAllByRecipeId(recipeId);
    }
}
