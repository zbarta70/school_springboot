package com.zbarta70.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zbarta70.school.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
}
