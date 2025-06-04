package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Conyuge;
import pe.company.repository.ConyugeRepository;

import java.util.Collection;
import java.util.Optional;
@Service
public class ConyugeServiceImpl implements ConyugeService {

    @Autowired
    private ConyugeRepository conyugeRepository;


    @Override
    public void insert(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    public void update(Conyuge conyuge) {
        conyugeRepository.save(conyuge);
    }

    @Override
    public void delete(Long conyugeDni) {
        conyugeRepository.deleteById(conyugeDni);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Conyuge> findById(Long conyugeDni) {
        return conyugeRepository.findById(conyugeDni);
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<Conyuge> findAll() {
        return (Collection<Conyuge>) conyugeRepository.findAll();
    }
}
