package referencedataguardian.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String faculty_name;

    private String external_id;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Departement> departements;

    @OneToMany(mappedBy = "attached_faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeaneryMember> deanery_members;
}