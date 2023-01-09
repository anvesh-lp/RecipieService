package com.anvesh.recipieservice.Repositories;

import com.anvesh.recipieservice.models.Recipie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipie, Long> {
}
