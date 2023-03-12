package ch.kra.reciperealm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static ch.kra.reciperealm.Strings.CANNOT_BE_EMPTY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    @NonNull
    @NotBlank(message = CANNOT_BE_EMPTY)
    private String ingredient;

    @NonNull
    @NotNull(message = CANNOT_BE_EMPTY)
    private double quantity;

    @NonNull
    @NotBlank(message = CANNOT_BE_EMPTY)
    private String uom;
}
