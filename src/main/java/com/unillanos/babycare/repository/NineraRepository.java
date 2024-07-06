package com.unillanos.babycare.repository;

import com.unillanos.babycare.model.Ninera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NineraRepository extends JpaRepository<Ninera, Long> {

}
