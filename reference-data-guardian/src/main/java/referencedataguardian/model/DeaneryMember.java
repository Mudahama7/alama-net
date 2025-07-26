package referencedataguardian.model;

import jakarta.persistence.*;
import lombok.Data;
import referencedataguardian.model.enums.DeaneryMember_sPositionHeld;

@Data
@Entity
public class DeaneryMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String registration_number;

    private String name;

    private String surname;

    private String first_name;

    private String email;

    private DeaneryMember_sPositionHeld position_held;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attached_fac")
    private Faculty attached_faculty;

}
