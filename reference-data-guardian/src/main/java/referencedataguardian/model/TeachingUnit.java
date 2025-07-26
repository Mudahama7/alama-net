package referencedataguardian.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TeachingUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String name;

    @OneToMany(mappedBy = "teachingUnit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeachingUnitElement> teachingUnitElements;

}
