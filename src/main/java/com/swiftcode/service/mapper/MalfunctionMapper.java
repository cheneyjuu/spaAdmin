package com.swiftcode.service.mapper;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.swiftcode.domain.Malfunction;
import com.swiftcode.service.dto.MalfunctionDTO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author chen
 **/
@Mapper(componentModel = "spring")
public interface MalfunctionMapper {
    Malfunction toEntity(MalfunctionDTO dto);

    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd")
    MalfunctionDTO toDto(Malfunction entity);

    default String map(List<String> value) {
        if (null != value) {
            return Joiner.on(",").join(value);
        }
        return StringUtils.EMPTY;
    }

    default List<String> map(String value) {
        if (null != value) {
            return Splitter.on(",").splitToList(value);
        }
        return Lists.newArrayListWithExpectedSize(0);
    }
}
