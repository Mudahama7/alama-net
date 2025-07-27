package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.DeaneryMemberDto;
import referencedataguardian.model.DeaneryMember;
import referencedataguardian.repository.DeaneryMermberRepository;
import referencedataguardian.service.DeaneryMemberService;
import referencedataguardian.service.mapper.DeaneryMemberMapper;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DeaneryMemberServiceImpl implements DeaneryMemberService {

    private final DeaneryMermberRepository deaneryMermberRepository;
    private final DeaneryMemberMapper deaneryMemberMapper;

    @Override
    public boolean saveDeaneryMembersForInitializeOurSystem(List<DeaneryMemberDto> deaneryMemberDtos) {
        List<DeaneryMember> deaneryMembers = deaneryMemberDtos.stream()
                .map(deaneryMemberMapper::mapFromDtoRequestToEntity)
                .toList();

        deaneryMermberRepository.saveAll(deaneryMembers);

        return true;
    }
}
