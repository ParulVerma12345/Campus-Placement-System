package com.parul.campusplacementsystem.repository;
import com.parul.campusplacementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository
extends JpaRepository<Student,Integer>{


}
