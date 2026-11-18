package isp.maven.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "repairbays")
public class Repairbays {

    @Id
    @Column(name = "idbay", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbay;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    public void setIdbay(Integer idbay) {
        this.idbay = idbay;
    }

    public Integer getIdbay() {
        return idbay;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return "Repairbays{" +
                "idbay='" + idbay + '\'' + ", " +
                "number='" + number + '\'' + ", " +
                "purpose='" + purpose + '\'' +
                '}';
    }
}
