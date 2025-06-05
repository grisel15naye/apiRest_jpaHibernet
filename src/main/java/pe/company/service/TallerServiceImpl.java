package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Taller;
import pe.company.repository.TallerRepository;

import java.util.Collection;
import java.util.List;

@Service
public class TallerServiceImpl implements TallerService {
    @Autowired
    private TallerRepository tallerRepository;
    @Override
    public void insert(Taller taller) {
        tallerRepository.save(taller);

    }

    @Override
    public void update(Taller taller) {
        tallerRepository.save(taller);

    }

    @Override
    public void delete(Long tallerId) {
        tallerRepository.deleteById(tallerId);

    }

    @Override
    @Transactional(readOnly = true)
    public Taller findById(Long tallerId) {
        return tallerRepository.findById(tallerId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Taller> finAll() {
        return (Collection<Taller>) tallerRepository.findAll();
    }
}
