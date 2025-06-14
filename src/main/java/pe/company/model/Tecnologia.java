package pe.company.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tecnologia")
public class Tecnologia implements Serializable {
    private static final long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tecnologiaId;

    @Column(nullable = false)
    private String nombre;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime fregistro;

    @ManyToMany(mappedBy = "itemsTecnologia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonBackReference
    private Set<Instructor> itemsInstructor=new HashSet<>();

    public Tecnologia(){}

    public Tecnologia(Long tecnologiaId, String nombre,LocalDateTime fregistro, Set<Instructor> itemsInstructor) {
        super();
        this.tecnologiaId = tecnologiaId;
        this.fregistro = fregistro;
        this.nombre=nombre;
        this.itemsInstructor = itemsInstructor;

    }

    public Long getTecnologiaId() {return tecnologiaId;}
    public void setTecnologiaId(Long tecnologiaId) {this.tecnologiaId = tecnologiaId;}
    public LocalDateTime getFregistro() {return fregistro;}
    public void setFregistro(LocalDateTime fregistro) {this.fregistro = fregistro;}
    public Set<Instructor> getItemsInstructor() {return itemsInstructor;}
    public void setItemsInstructor(Set<Instructor> itemsInstructor) {this.itemsInstructor = itemsInstructor;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
