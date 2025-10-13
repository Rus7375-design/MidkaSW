package src.main.java.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.dto.entity.StudentEntity;

@Repository
public interface StudentRep extends JpaRepository<StudentEntity, Long> {
}