package pe.company.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "conyuge")
public class Conyuge implements Serializable {
    private static final  long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conyugeDni;

    @Column(nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "instructor_id", nullable = false, unique = true,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (instructor_id) references instructor(instructor_id)"))
    @JsonBackReference
    private Instructor instructor;

    public Conyuge (){};
    public Conyuge(Long conyugeDni, String nombre, Instructor instructor){
        super();
        this.conyugeDni=conyugeDni;
        this.nombre=nombre;
        this.instructor=instructor;
    }

    public Long getConyugeDni() {return conyugeDni;}
    public void setConyugeDni(Long conyugeDni) {this.conyugeDni = conyugeDni;}
    public Instructor getInstructor() {return instructor;}
    public void setInstructor(Instructor instructor) {this.instructor = instructor;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
}
