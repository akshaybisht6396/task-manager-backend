package com.railways.demo.repository;

import com.railways.demo.entity.Task; // CRITICAL: Ensure this import is here
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // CRITICAL: Ensure this is imported for the method below

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
}