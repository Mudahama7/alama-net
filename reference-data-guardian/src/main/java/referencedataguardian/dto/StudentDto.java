package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDto {

    private String registration_number;

    private String name;

    private String surname;

    private String first_name;

    private char gender;

    private String email;

    private String address;

    private PromotionDto promotion;

}