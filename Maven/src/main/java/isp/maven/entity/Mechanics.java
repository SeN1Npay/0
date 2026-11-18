package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "mechanics")
public class Mechanics {

    @Id
    @Column(name = "idmechanic", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmechanic;

    @JsonIgnore
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private Users iduser;

    public void setIdmechanic(Integer idmechanic) {
        this.idmechanic = idmechanic;
    }

    public Integer getIdmechanic() {
        return idmechanic;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    public Users getIduser() {
        return iduser;
    }

    @Override
    public String toString() {
        return "Mechanics{" +
                "idmechanic='" + idmechanic + '\'' + ", " +
                "iduser='" + iduser + '\'' +
                '}';
    }
}
