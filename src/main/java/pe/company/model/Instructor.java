package pe.company.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="instructor")
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id", nullable = false)
    private Long instructorId;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellidos;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(length = 50)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime fregistro;

    @OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Conyuge conyuge;

    @OneToMany(mappedBy = "instructor")
    private Collection<Taller> itemsTaller=new ArrayList<>();

    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name="instructores_tecnologias",
            joinColumns=@JoinColumn(name="instructor_id",nullable=false,
                    foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(instructor_id) references instructor(instructor_id)")),
            inverseJoinColumns=@JoinColumn(name="tecnologia_id",nullable=false,
                    foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(tecnologia_id) references tecnologia(tecnologia_id)")))

    private Set<Tecnologia> itemsTecnologia=new HashSet<>();

    public Instructor() {}

    public Instructor(Long instructorId, String nombre, String apellidos, String password, String email,
                      LocalDateTime fregistro, Conyuge conyuge, Collection<Taller> itemsTaller, Set<Tecnologia> itemsTecnologia) {
        super();
        this.instructorId = instructorId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.email = email;
        this.fregistro = fregistro;
        this.conyuge = conyuge;
        this.itemsTaller = itemsTaller;
        this.itemsTecnologia = itemsTecnologia;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getFregistro() {
        return fregistro;
    }

    public void setFregistro(LocalDateTime fregistro) {
        this.fregistro = fregistro;
    }

    public Conyuge getConyuge() {
        return conyuge;
    }

    public void setConyuge(Conyuge conyuge) {
        this.conyuge = conyuge;
    }

    public Collection<Taller> getItemsTaller() {
        return itemsTaller;
    }

    public void setItemsTaller(Collection<Taller> itemsTaller) {
        this.itemsTaller = itemsTaller;
    }

    public Set<Tecnologia> getItemsTecnologia() {
        return itemsTecnologia;
    }

    public void setItemsTecnologia(Set<Tecnologia> itemsTecnologia) {
        this.itemsTecnologia = itemsTecnologia;
    }

    public void addTecnologia(Tecnologia tecnologia) {
        if (!itemsTecnologia.contains(tecnologia)) {
            itemsTecnologia.add(tecnologia);
        }
    }
}



