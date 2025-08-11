package result_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class ResultBulletinContent {

    private Map<StudentInfosForResult, List<ResultBulletinLine>> studentResultBulletinLines;

}
