package referencedataguardian.service.contract;

import referencedataguardian.dto.DeaneryMemberDto;

import java.util.List;

public interface DeaneryMemberService {

    boolean saveDeaneryMembersForInitializeOurSystem(List<DeaneryMemberDto> deaneryMemberDtos);

}
