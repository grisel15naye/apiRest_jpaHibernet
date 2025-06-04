package pe.company.model;

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

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime fregistro;

    @ManyToMany(mappedBy = "itemsTecnologia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Instructor> itemsInstructor=new HashSet<>();

    public Tecnologia(){}

    public Tecnologia(Long tecnologiaId, LocalDateTime fregistro, Set<Instructor> itemsInstructor) {
        super();
        this.tecnologiaId = tecnologiaId;
        this.fregistro = fregistro;
        this.itemsInstructor = itemsInstructor;
    }

    public Long getTecnologiaId() {return tecnologiaId;}
    public void setTecnologiaId(Long tecnologiaId) {this.tecnologiaId = tecnologiaId;}
    public LocalDateTime getFregistro() {return fregistro;}
    public void setFregistro(LocalDateTime fregistro) {this.fregistro = fregistro;}
    public Set<Instructor> getItemsInstructor() {return itemsInstructor;}
    public void setItemsInstructor(Set<Instructor> itemsInstructor) {this.itemsInstructor = itemsInstructor;}
}
