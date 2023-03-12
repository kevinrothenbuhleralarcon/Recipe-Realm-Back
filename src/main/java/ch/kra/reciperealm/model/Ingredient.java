package ch.kra.reciperealm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static ch.kra.reciperealm.Strings.CANNOT_BE_EMPTY;

@Getter
@Setter
@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @NotBlank(message = CANNOT_BE_EMPTY)
    private String ingredient;

    @NonNull
    @NotNull(message = CANNOT_BE_EMPTY)
    private double quantity;

    @NonNull
    @NotBlank(message = CANNOT_BE_EMPTY)
    private String uom;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    @JsonBackReference("recipe_ingredients")
    private Recipe recipe;
}
