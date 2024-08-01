package com.zbarta70.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zbarta70.school.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
