package ch.kra.reciperealm.repository;

import ch.kra.reciperealm.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findAllByRecipeId(Long id);
}
