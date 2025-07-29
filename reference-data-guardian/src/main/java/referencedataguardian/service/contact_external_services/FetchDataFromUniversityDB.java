package referencedataguardian.service.contact_external_services;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import referencedataguardian.dto.StudentDto;
import referencedataguardian.dto.TeacherDto;
import referencedataguardian.dto.TeachingUnitElementDto;

import java.util.List;

@AllArgsConstructor
@Service
public class FetchDataFromUniversityDB {

    private RestTemplate restTemplate;


    public List<TeacherDto> getAllTeachers(String url_api) {
        ResponseEntity<List<TeacherDto>> response = restTemplate.exchange(
                url_api,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TeacherDto>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Impossible de récupérer les teachers : " + response.getStatusCode());
        }
    }

    public List<StudentDto> getAllStudent(String url_api) {
        ResponseEntity<List<StudentDto>> response = restTemplate.exchange(
                url_api,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StudentDto>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Impossible de récupérer les étudiants : " + response.getStatusCode());
        }
    }

    public List<TeachingUnitElementDto> getAllUEU(String url_api) {
        ResponseEntity<List<TeachingUnitElementDto>> response = restTemplate.exchange(
                url_api,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TeachingUnitElementDto>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Impossible de récupérer les cours : " + response.getStatusCode());
        }
    }


}