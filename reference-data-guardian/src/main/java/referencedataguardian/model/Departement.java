package referencedataguardian.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String designation;

    private String chef_name;

    private String external_id;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Promotion> promotions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
