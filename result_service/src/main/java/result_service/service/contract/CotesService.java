package result_service.service.contract;

import result_service.dto.NewCoteRequest;

public interface CotesService {

    boolean saveCotes(NewCoteRequest newCoteRequest);

}
