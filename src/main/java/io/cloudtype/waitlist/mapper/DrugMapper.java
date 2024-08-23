package io.cloudtype.waitlist.mapper;

import io.cloudtype.waitlist.dto.DrugDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DrugMapper {
    DrugDto searchDrug(@Param("tki") String tki, @Param("drug") String drug);
}
