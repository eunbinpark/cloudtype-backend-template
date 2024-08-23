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
        return drugMapper.searchDrug(tki, drug);
    }
}
