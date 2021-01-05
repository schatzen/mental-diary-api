package com.mentaldiary.mentalapi.respository;

import com.mentaldiary.mentalapi.entity.Category;
import com.mentaldiary.mentalapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

}
