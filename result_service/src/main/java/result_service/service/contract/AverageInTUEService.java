package result_service.service.contract;

import result_service.dto.ResultBulletinLine;
import result_service.model.Cotes;

import java.util.List;

public interface AverageInTUEService {

    List<ResultBulletinLine> calculateStudentAverage(List<Cotes> studentCotes);

}
