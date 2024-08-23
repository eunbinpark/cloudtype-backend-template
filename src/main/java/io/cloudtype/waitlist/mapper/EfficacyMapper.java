package io.cloudtype.waitlist.mapper;

import io.cloudtype.waitlist.dto.EfficacyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EfficacyMapper {
    EfficacyDto selectEfficacy(@Param("tki") String tki, @Param("efficacy") String efficacy);
}
