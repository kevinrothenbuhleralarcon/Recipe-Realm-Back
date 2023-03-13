package ch.kra.reciperealm.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeFullDto extends RecipeDto {

    @JsonManagedReference("recipe_ingredients")
    private List<IngredientDto> ingredients;
}
