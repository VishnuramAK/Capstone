package com.example.safewell.repository;

import com.example.safewell.model.UnsafeArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnsafeAreaRepository extends JpaRepository<UnsafeArea, Long> {
    List<UnsafeArea> findAll();
}