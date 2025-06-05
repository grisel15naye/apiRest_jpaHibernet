package pe.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Instructor;
import pe.company.repository.InstructorRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
public class InstructorServiceImpl implements InstructorService{
    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public void insert(Instructor instructor) {
        instructorRepository.save(instructor);

    }

    @Override
    public void update(Instructor instructor) {
        instructorRepository.save(instructor);

    }

    @Override
    public void delete(Long instructorId) {
        instructorRepository.deleteById(instructorId);

    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(Long instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Instructor> findAll() {
        return (Collection<Instructor>)instructorRepository.findAll();
    }
}
