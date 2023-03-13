package ch.kra.reciperealm.service;

import ch.kra.reciperealm.dto.RecipeFullDto;
import ch.kra.reciperealm.dto.RecipeDto;
import ch.kra.reciperealm.exception.EntityNotFoundException;
import ch.kra.reciperealm.model.Ingredient;
import ch.kra.reciperealm.model.Recipe;
import ch.kra.reciperealm.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private final ModelMapper modelMapper;

    @Override
    public List<RecipeDto> getRecipes() {
        List<Recipe> recipes = (List<Recipe>)recipeRepository.findAll();
        return recipes.stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecipeFullDto getRecipe(final Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Recipe.class));


        return modelMapper.map(recipe, RecipeFullDto.class);
    }

    @Override
    public RecipeFullDto addRecipe(final RecipeFullDto recipeFullDto) {
        Recipe recipe = modelMapper.map(recipeFullDto, Recipe.class);
        Recipe savedRecipe = recipeRepository.save(recipe);

        return modelMapper.map(savedRecipe, RecipeFullDto.class);
    }
}
