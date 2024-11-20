package civa.reto.apiBuses.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int numeroBus;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private String caracteristicas;
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date created_at;
    @Column(nullable = false)
    private boolean is_active;
    @ManyToOne
    @JoinColumn(name = "marcabus_id")
    private MarcaBus marcabus;

    @PrePersist
    public void onCreate() {
        this.created_at = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(int numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public MarcaBus getMarcabus() {
        return marcabus;
    }

    public void setMarcabus(MarcaBus marcabus) {
        this.marcabus = marcabus;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", numeroBus=" + numeroBus +
                ", placa='" + placa + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", created_at=" + created_at +
                ", is_active=" + is_active +
                ", marcabus=" + marcabus +
                '}';
    }
}
