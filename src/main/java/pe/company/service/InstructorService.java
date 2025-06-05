package pe.company.service;

import pe.company.model.Instructor;

import java.util.Collection;
import java.util.Optional;

public interface InstructorService {
    public abstract void insert (Instructor instructor);
    public abstract void  update (Instructor instructor);
    public abstract void delete (Long instructorId);
    public abstract Instructor findById(Long instructorId);
    public abstract Collection<Instructor> findAll();
}
