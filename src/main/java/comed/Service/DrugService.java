package comed.Service;

import comed.dto.DrugDto;
import comed.mapper.DrugMapper;
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
            result = new DrugDto(); // 새로운 객체를 생성
            result.setDdi("정보없음");
            result.setEfficacy("정보없음");
        }
        System.out.println("result: " + result);
        return result;
    }
}
