package pe.company.service;

import pe.company.model.Taller;

import java.util.Collection;

public interface TallerService {
    public abstract void insert (Taller taller);
    public abstract void update (Taller taller);
    public abstract void delete (Long tallerId);
    public abstract Taller findById(Long tallerId);
    public abstract Collection<Taller> finAll();
}
