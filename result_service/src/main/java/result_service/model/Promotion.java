package result_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Promotion  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String designation;

    private String department;

    private String faculty;

    private String externalId;

    private String academic_year;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    private List<Student> students;

    @OneToMany(mappedBy = "promotion", fetch = FetchType.LAZY)
    private List<TeachingUnitElement> teachingUnitElements;

}
