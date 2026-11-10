package com.parul.campusplacementsystem.repository;

import com.parul.campusplacementsystem.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {
}