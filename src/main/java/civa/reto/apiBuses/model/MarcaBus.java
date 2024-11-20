package civa.reto.apiBuses.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "marca_bus")
public class MarcaBus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @OneToMany(mappedBy = "marcabus", cascade = CascadeType.ALL)
    private List<Bus> buses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    @Override
    public String toString() {
        return "MarcaBus{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
