package referencedataguardian.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String registrationNumber;

    private String name;

    private String surname;

    private String first_name;

    private String level;

    private String email;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<TeachingUnitElement> teachingUnitElementList;

}
