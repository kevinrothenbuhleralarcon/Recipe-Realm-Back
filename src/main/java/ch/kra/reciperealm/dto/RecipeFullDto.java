package ch.kra.reciperealm.dto;


import ch.kra.reciperealm.model.Ingredient;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

import static ch.kra.reciperealm.Strings.CANNOT_BE_EMPTY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeFullDto {

    private long id;

    @NonNull
    @NotBlank(message = CANNOT_BE_EMPTY)
    private String name;

    private List<IngredientDto> ingredients;
}
