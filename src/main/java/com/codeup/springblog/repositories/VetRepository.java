package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
