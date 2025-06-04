package pe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.Instructor;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}