package io.cloudtype.waitlist.Service;

import io.cloudtype.waitlist.dto.EfficacyDto;
import io.cloudtype.waitlist.mapper.EfficacyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EfficacyService {
    private final EfficacyMapper efficacyMapper;

    @Autowired
    public EfficacyService(EfficacyMapper efficacyMapper) {
        this.efficacyMapper = efficacyMapper;
    }

    public EfficacyDto searchEfficacy(String tki, String efficacy) {
        return efficacyMapper.selectEfficacy(tki, efficacy);
    }
}
