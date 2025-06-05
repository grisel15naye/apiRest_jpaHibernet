package pe.company.service;

import pe.company.model.Taller;
import pe.company.model.Tecnologia;

import java.util.Collection;

public interface TecnologiaService {
    public abstract void insert (Tecnologia tecnologia);
    public abstract void update (Tecnologia tecnologia);
    public abstract void delete (Long tecnologiaId);
    public abstract Tecnologia findById(Long tecnologiaId);
    public abstract Collection<Tecnologia>findAll();
}
