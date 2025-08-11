package result_service.service.contract;

import jakarta.mail.MessagingException;
import result_service.dto.NewCoteRequest;
import result_service.dto.ResultBulletinContent;
import result_service.dto.StatisticView;
import result_service.dto.request_objects.StatisticTUEVisualizationRequest;

import java.util.List;

public interface CotesService {

    boolean saveCotes(NewCoteRequest newCoteRequest) throws MessagingException;

    StatisticView generateStatistic(StatisticTUEVisualizationRequest statisticTUEVisualizationRequest);

    List<ResultBulletinContent> generateBulletinForAPromotion(String promotion_external_id);

    ResultBulletinContent generateBulletinForAStudent();

}
