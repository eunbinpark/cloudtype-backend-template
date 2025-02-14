package comed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ingredient")
    private String ingredient;

    @Column(name = "ddi")
    private String ddi;

    @Column(name = "efficacy")
    private String efficacy;

    // JPQL 쿼리에서 사용하는 생성자
    public Drug(String ingredient, String ddi, String efficacy) {
        this.ingredient = ingredient;
        this.ddi = ddi;
        this.efficacy = efficacy;
    }
}
