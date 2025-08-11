package result_service.controller;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import result_service.dto.NewCoteRequest;
import result_service.dto.ResultBulletinContent;
import result_service.dto.StatisticView;
import result_service.dto.request_objects.StatisticTUEVisualizationRequest;
import result_service.service.contract.CotesService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/alama_net/result_service/")
public class CotesController {

    private final CotesService cotesService;

    @PreAuthorize("hasAuthority('ceate-cote')")
    @PostMapping("create_cote")
    public boolean createCote(@RequestBody NewCoteRequest cotes) throws MessagingException {
        return cotesService.saveCotes(cotes);
    }

    @PreAuthorize("hasAuthority('statistic-tue-visualization')")
    @PostMapping("statistic_tue_visualization")
    public StatisticView generationStatisticTueVisualization(@RequestBody StatisticTUEVisualizationRequest statisticTUEVisualizationRequest){
        return cotesService.generateStatistic(statisticTUEVisualizationRequest);
    }

    @PreAuthorize("hasAuthority('generate-promotion-bulletin')")
    @PostMapping("generate_promotion_bulletin/{promotion_external_id}")
    public List<ResultBulletinContent> generatePromotionBulletin(@PathVariable String promotion_external_id) {
        return cotesService.generateBulletinForAPromotion(promotion_external_id);
    }

    @PreAuthorize("hasAuthority('generate-my-own-bulletin')")
    @GetMapping("generate_my_own_bulletin")
    public ResultBulletinContent generateMyOwnBulletin() {
        return cotesService.generateBulletinForAStudent();
    }

}