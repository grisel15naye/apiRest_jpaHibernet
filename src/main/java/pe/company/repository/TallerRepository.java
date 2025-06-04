package pe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.Taller;
@Repository
public interface TallerRepository extends JpaRepository<Taller, Long> {
}