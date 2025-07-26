package referencedataguardian.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TeachingUnitElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String name;

    private int credits;

    private int hourly_volume;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teaching_unit_id")
    private TeachingUnit teachingUnit;

}
