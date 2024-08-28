package io.cloudtype.waitlist.Service;

import io.cloudtype.waitlist.dto.DrugDto;
import io.cloudtype.waitlist.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugService {
    private final DrugMapper drugMapper;

    @Autowired
    public DrugService(DrugMapper drugMapper){
        this.drugMapper = drugMapper;
    }

    public DrugDto searchDrug(String tki, String drug){
        DrugDto result = drugMapper.searchDrug(tki, drug);
        if (result == null) {
            result.setDdi("금기 또는 주의를 요하는 약물 리스트에 없는 약물입니다.");
            result.setEfficacy("정보없음");
        }
        return result;
    }
}
