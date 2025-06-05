package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.company.model.Tecnologia;
import pe.company.repository.TecnologiaRepository;

import java.util.Collection;
import java.util.List;
@Service
public class TecnologiaServiceImpl implements TecnologiaService{
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    @Override
    public void insert(Tecnologia tecnologia) {
        tecnologiaRepository.save(tecnologia);

    }

    @Override
    public void update(Tecnologia tecnologia) {
        tecnologiaRepository.save(tecnologia);

    }

    @Override
    public void delete(Long tecnologiaId) {
        tecnologiaRepository.deleteById(tecnologiaId);

    }

    @Override
    public Tecnologia findById(Long tecnologiaId) {
        return tecnologiaRepository.findById(tecnologiaId).orElse(null);
    }

    @Override
    public Collection<Tecnologia> findAll() {
        return (Collection<Tecnologia>) tecnologiaRepository.findAll();
    }
}
