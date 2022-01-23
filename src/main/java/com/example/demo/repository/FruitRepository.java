package com.example.demo.repository;

import com.example.demo.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    Fruit getFruitsByName(String name);

    default Fruit update(Long id) {
        Fruit fruit = getById(id);
        return save(fruit);
    }
}