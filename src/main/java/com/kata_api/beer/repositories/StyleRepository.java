package com.kata_api.beer.repositories;

import com.kata_api.beer.entities.Styles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StyleRepository extends JpaRepository<Styles, Integer> {
    Page<Styles> findAllByOrderByStyleNameAsc(Pageable pageable);
    Page<Styles> findAllByOrderById(Integer id, Pageable pageable);
}
