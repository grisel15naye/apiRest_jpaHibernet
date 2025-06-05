package pe.company.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "taller")
public class Taller implements Serializable {
    private static final long SerialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tallerId;

    @Column(unique = true)
    private String nombre;

    @Column(nullable = false)
    private Double costo;

    @ManyToOne
    @JoinColumn(name = "instructor_id", unique = false,
    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (instructor_id) references instructor (instructor_id)"))
    @JsonBackReference
    private Instructor instructor;
    public Taller(){}

    public Taller(Long tallerId, String nombre, Double costo, Instructor instructor) {
        super();
        this.tallerId = tallerId;
        this.nombre = nombre;
        this.costo = costo;
        this.instructor = instructor;
    }

    public Long getTallerId() {return tallerId;}
    public void setTallerId(Long tallerId) {this.tallerId = tallerId;}public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Double getCosto() {return costo;}
    public void setCosto(Double costo) {this.costo = costo;}
    public Instructor getInstructor() {return instructor;}
    public void setInstructor(Instructor instructor) {this.instructor = instructor;
    }
}
