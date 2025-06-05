package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Conyuge;
import pe.company.model.Instructor;
import pe.company.repository.ConyugeRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ConyugeService {
    public abstract  void insert (Conyuge conyuge);
    public abstract void update (Conyuge conyuge);
    public abstract void delete (Long conyugeDni);
    public abstract Conyuge findById(Long conyugeDni);
    public abstract Collection<Conyuge> findAll();

}
