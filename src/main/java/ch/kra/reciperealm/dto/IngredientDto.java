package ch.kra.reciperealm.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static ch.kra.reciperealm.Strings.CANNOT_BE_EMPTY;

@Getter
@Setter
public class IngredientDto {

    private Long id;

    @NotBlank(message = CANNOT_BE_EMPTY)
    private String ingredient;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Double quantity;

    @NotBlank(message = CANNOT_BE_EMPTY)
    private String uom;

    @JsonBackReference("recipe_ingredients")
    private RecipeDto recipe;
}
