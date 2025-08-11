package result_service.service.implementation;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import result_service.dto.NewCoteRequest;
import result_service.dto.ResultBulletinContent;
import result_service.dto.StatisticView;
import result_service.dto.request_objects.StatisticTUEVisualizationRequest;
import result_service.model.Cotes;
import result_service.model.Promotion;
import result_service.model.TeachingUnitElement;
import result_service.repository.CotesRepository;
import result_service.service.contract.CotesService;
import result_service.service.contract.PromotionService;
import result_service.service.contract.StudentService;
import result_service.service.contract.TeachingUnitElementService;
import result_service.service.mapper.CotesMapper;
import result_service.service.mapper.ResultBulletinBuilder;
import result_service.service.util.MailService;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class CotesServiceImpl implements CotesService {

    private final CotesRepository cotesRepository;
    private final CotesMapper cotesMapper;
    private final PromotionService promotionService;
    private final StudentService studentService;
    private final TeachingUnitElementService teachingUnitElementService;
    private final MailService mailService;
    private final ResultBulletinBuilder resultBulletinBuilder;

    @Override
    public boolean saveCotes(NewCoteRequest newCoteRequest) throws MessagingException {

        promotionService.savePromotion(newCoteRequest.getPromotionReq());
        studentService.saveStudent(newCoteRequest.getStudentReq());
        teachingUnitElementService.saveTeachingUnitElement(newCoteRequest.getTeachingUnitElementReq());

        Cotes cotes = cotesMapper.mapFromRequestToCotes(newCoteRequest);
        cotesRepository.save(cotes);

        mailService.sendMail(
                newCoteRequest.getStudentReq().getEmail(),
                newCoteRequest.getStudentReq().getFirst_name(),
                newCoteRequest.getTeachingUnitElementReq().getDesignation()
        );

        return true;
    }

    @Override
    public StatisticView generateStatistic(StatisticTUEVisualizationRequest statisticTUEVisualizationRequest) {

        String codeTeachingUnit = statisticTUEVisualizationRequest.getCodeTeachingUnit();
        String type_cote = statisticTUEVisualizationRequest.getType_cote();
        TeachingUnitElement teachingUnitElement = teachingUnitElementService.findTeachingUnitElementByCode(codeTeachingUnit);

        String distinction_total = String.valueOf(
                teachingUnitElement.getCotes().stream()
                        .filter(cote ->
                                cote.getCote() >= (cote.getTotal() * 70) / 100
                                && Objects.equals(cote.getType_cote().toString(), type_cote))
                        .count()
        );

        String success_total = String.valueOf(
                teachingUnitElement.getCotes().stream()
                        .filter(cote ->
                                cote.getCote() >= (cote.getTotal() * 50) / 100
                                && cote.getCote() <= (cote.getTotal() * 70) / 100
                                && Objects.equals(cote.getType_cote().toString(), type_cote))
                        .count()
        );

        String slight_failure_total = String.valueOf(
                teachingUnitElement.getCotes().stream()
                        .filter(cote ->
                                cote.getCote() <= (cote.getTotal() * 50) / 100
                                && cote.getCote() >= (cote.getTotal() * 30) / 100
                                && Objects.equals(cote.getType_cote().toString(), type_cote))
                        .count()
        );

        String deep_failure_total = String.valueOf(
                teachingUnitElement.getCotes().stream()
                        .filter(cote ->
                                cote.getCote() <= (cote.getTotal() * 30) / 100
                                && Objects.equals(cote.getType_cote().toString(), type_cote)
                        )
                        .count()
        );

        return StatisticView.builder()
                .deep_failure_total(deep_failure_total)
                .success_total(success_total)
                .distinction_total(distinction_total)
                .slight_failure_total(slight_failure_total)
                .build();
    }

    @Override
    public List<ResultBulletinContent> generateBulletinForAPromotion(String promotion_external_id) {
        Promotion promotion = promotionService.findPromotionByExternal_id(promotion_external_id);

        return resultBulletinBuilder
                .buildingResultBulletinByCalculateDifferentAveragesForAPromotion(
                        promotion.getStudents()
                );
    }

    @Override
    public ResultBulletinContent generateBulletinForAStudent() {
        String connectedStudentUsername = SecurityContextHolder.getContext().getAuthentication()
                .getName();
        return resultBulletinBuilder.buildingResultBulletinByCalculateDifferentAveragesForAStudent(connectedStudentUsername);
    }

}