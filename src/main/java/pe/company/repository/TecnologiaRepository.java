package pe.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.company.model.Tecnologia;
@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {
  }