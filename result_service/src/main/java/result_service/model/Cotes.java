package result_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import result_service.model.enums.Type_cote;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Number cote;

    private Type_cote type_cote;

    private LocalDateTime date = LocalDateTime.now();

}
