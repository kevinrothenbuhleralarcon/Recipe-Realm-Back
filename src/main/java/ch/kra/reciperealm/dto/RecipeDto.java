package ch.kra.reciperealm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static ch.kra.reciperealm.Strings.CANNOT_BE_EMPTY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private long id;

    @NotBlank(message = CANNOT_BE_EMPTY)
    private String name;

    @NotNull(message = CANNOT_BE_EMPTY)
    private Long numberOfPeople;
}
