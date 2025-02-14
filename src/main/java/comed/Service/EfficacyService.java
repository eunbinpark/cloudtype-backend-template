package comed.Service;

import comed.dto.EfficacyDto;
import comed.mapper.EfficacyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EfficacyService {
    private final EfficacyMapper efficacyMapper;

    @Autowired
    public EfficacyService(EfficacyMapper efficacyMapper) {
        this.efficacyMapper = efficacyMapper;
    }

    public List<comed.dto.EfficacyDto> searchEfficacy(String tki, String efficacy) {
        List<EfficacyDto> result = efficacyMapper.searchEfficacy(tki, efficacy);
        if (result == null || result.isEmpty()) {
            result = new ArrayList<>();
            EfficacyDto efficacyDto = new EfficacyDto();
            efficacyDto.setIngredient(null);
            result.add(efficacyDto);
        }
        return result;
    }
}
