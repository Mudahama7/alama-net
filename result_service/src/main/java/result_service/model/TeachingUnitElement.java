package result_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.sqm.FetchClauseType;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TeachingUnitElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String designation;

    private int credits;

    private String teachingUnitDesignation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Promotion promotion;

    @OneToMany(mappedBy = "teachingUnit", fetch = FetchType.LAZY)
    private List<Cotes> cotes;

    @OneToMany(mappedBy = "teachingUnitElement", fetch = FetchType.LAZY)
    private List<AverageInTUE> averageInTUE;

}