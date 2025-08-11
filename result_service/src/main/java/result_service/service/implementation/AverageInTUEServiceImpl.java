package result_service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.ResultBulletinLine;
import result_service.model.AverageInTUE;
import result_service.model.Cotes;
import result_service.model.TeachingUnitElement;
import result_service.service.contract.AverageInTUEService;
import result_service.service.mapper.AverageInTUEMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AverageInTUEServiceImpl implements AverageInTUEService {

    private final AverageInTUEMapper averageInTUEMapper;

    @Override
    public List<ResultBulletinLine> calculateStudentAverage(List<Cotes> studentCotes) {

        Map<TeachingUnitElement, List<Cotes>> groupedByElement = studentCotes.stream()
                .collect(Collectors.groupingBy(Cotes::getTeachingUnit));

        List<ResultBulletinLine> resultBulletinLines = new ArrayList<>();

        for (Map.Entry<TeachingUnitElement, List<Cotes>> entry : groupedByElement.entrySet()) {

            TeachingUnitElement tue = entry.getKey();
            List<Cotes> cotes = entry.getValue();

            AverageInTUE averageInTUE = new AverageInTUE();

            Double total_tp_td = 0.0;
            Double total_tp_td_out_to = 0.0;

            Double total_interrogation = 0.0;
            Double total_interrogation_out_to = 0.0;

            averageInTUE.setTeachingUnitElement(tue);

            for (Cotes cote : cotes) {

                if (cote.getType_cote().toString().equals("travail_pratique")
                    || cote.getType_cote().toString().equals("travail_dirige")
                ){
                    total_tp_td += cote.getCote();
                    total_tp_td_out_to += cote.getTotal();
                }
                double tp_td_out_of_twenty = total_tp_td * 20 / total_tp_td_out_to;
                averageInTUE.setAverage_on_tp_td(tp_td_out_of_twenty * 30 / 100);

                if (cote.getType_cote().toString().equals("interrogation")){
                    total_interrogation += cote.getCote();
                    total_interrogation_out_to += cote.getTotal();
                }
                double interrogation_out_of_twenty = total_interrogation * 20 / total_interrogation_out_to;
                averageInTUE.setAverage_on_interrogation(interrogation_out_of_twenty * 20 / 100);

                if (cote.getType_cote().toString().equals("exam_first_session")){
                    double exam_first_session_out_of_twenty = cote.getCote() * 20/cote.getTotal();
                    averageInTUE.setAverage_on_exam(exam_first_session_out_of_twenty * 50 / 100);
                }

                ResultBulletinLine line = averageInTUEMapper.fromAverageInTUEToResultSlipLine(averageInTUE);
                resultBulletinLines.add(line);

            }

        }

        return resultBulletinLines;
    }



}