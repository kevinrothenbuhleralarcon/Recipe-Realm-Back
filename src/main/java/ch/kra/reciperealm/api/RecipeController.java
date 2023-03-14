package ch.kra.reciperealm.api;

import ch.kra.reciperealm.dto.RecipeFullDto;
import ch.kra.reciperealm.dto.RecipeDto;
import ch.kra.reciperealm.model.Recipe;
import ch.kra.reciperealm.service.RecipeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping()
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeFullDto> getRecipe(@PathVariable final Long id) {
        return new ResponseEntity<>(recipeService.getRecipe(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RecipeFullDto> addRecipe(@RequestBody @Valid final RecipeFullDto recipeFullDto) {
        return new ResponseEntity<>(recipeService.addRecipe(recipeFullDto), HttpStatus.CREATED);
    }
}
