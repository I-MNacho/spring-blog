package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
