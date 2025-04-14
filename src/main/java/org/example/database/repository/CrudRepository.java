package org.example.database.repository;

import java.util.Optional;

public interface CrudRepository <E, K>{

    Optional<E> findById(K id);

    void delete(E entity);
}
