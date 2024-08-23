package io.cloudtype.waitlist.mapper;

import io.cloudtype.waitlist.dto.EfficacyDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EfficacyMapper {
    List<EfficacyDto> searchEfficacy(@Param("tki") String tki, @Param("efficacy") String efficacy);
}