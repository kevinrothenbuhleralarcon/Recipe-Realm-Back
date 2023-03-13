package ch.kra.reciperealm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static ch.kra.reciperealm.Strings.CANNOT_BE_EMPTY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {

    private long id;

    @NonNull
    @NotBlank(message = CANNOT_BE_EMPTY)
    private String name;
}
