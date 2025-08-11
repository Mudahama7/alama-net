package result_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AverageInTUE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double average_on_tp_td;

    private Double average_on_interrogation;

    private Double average_on_exam;

    @ManyToOne
    private TeachingUnitElement teachingUnitElement;

}
