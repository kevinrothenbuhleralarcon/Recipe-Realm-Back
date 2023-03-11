package ch.kra.reciperealm.service;

import ch.kra.reciperealm.model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient);
    List<Ingredient> addIngredients(List<Ingredient> ingredients);
}
