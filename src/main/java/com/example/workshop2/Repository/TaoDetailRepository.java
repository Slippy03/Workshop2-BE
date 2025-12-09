package com.example.workshop2.Repository;

import com.example.workshop2.Entity.TaoDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaoDetailRepository extends JpaRepository<TaoDetailEntity, Integer> {
}