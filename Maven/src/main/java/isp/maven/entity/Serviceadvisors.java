package isp.maven.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "serviceadvisors")
public class Serviceadvisors {

    @Id
    @Column(name = "idadvisor", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idadvisor;

    @JsonIgnore
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private Users iduser;

    public void setIdadvisor(Integer idadvisor) {
        this.idadvisor = idadvisor;
    }

    public Integer getIdadvisor() {
        return idadvisor;
    }

    public void setIduser(Users iduser) {
        this.iduser = iduser;
    }

    public Users getIduser() {
        return iduser;
    }

    @Override
    public String toString() {
        return "Serviceadvisors{" +
                "idadvisor='" + idadvisor + '\'' + ", " +
                "iduser='" + iduser + '\'' +
                '}';
    }
}
