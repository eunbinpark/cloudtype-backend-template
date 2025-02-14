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
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number", nullable = false)
    private int num;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    @Column(name = "entered")
    private boolean entered = false;

    @Column(name = "is_canceled")
    private boolean isCanceled = false;
}
