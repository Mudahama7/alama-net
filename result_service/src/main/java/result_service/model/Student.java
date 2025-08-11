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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String registrationNumber;

    private String email;

    private String name;

    private String surname;

    private String first_name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Promotion promotion;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Cotes> cotes;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<AverageInTUE> averageInTUE;

}
