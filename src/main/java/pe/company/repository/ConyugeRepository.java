package pe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.Conyuge;
@Repository
public interface ConyugeRepository extends JpaRepository<Conyuge, Long> {
}