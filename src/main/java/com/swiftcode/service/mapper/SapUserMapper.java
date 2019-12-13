package com.swiftcode.service.mapper;

import com.swiftcode.domain.SapUser;
import com.swiftcode.service.dto.SapUserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author chen
 **/
@Mapper(componentModel = "spring")
public interface SapUserMapper {
    @Mappings({
        @Mapping(source = "PERNR", target = "userCode"),
        @Mapping(source = "ENAME", target = "userName"),
        @Mapping(source = "SORTB", target = "jobCode"),
        @Mapping(source = "SORTT", target = "jobName"),
        @Mapping(source = "CPLGR", target = "regionCode"),
        @Mapping(source = "CPLTX", target = "regionName"),
        @Mapping(source = "MATYP", target = "branchCode"),
        @Mapping(source = "MATYT", target = "branchName"),
        @Mapping(source = "WERKS", target = "factoryCode"),
        @Mapping(source = "TXTMD", target = "factoryName"),
        @Mapping(source = "WCTYPE", target = "isMalStaff"),
        @Mapping(source = "phoneNumber", target = "phoneNumber")
    })
    SapUser toEntity(SapUserDTO dto);

    @InheritInverseConfiguration
    SapUserDTO toDto(SapUser sapUser);
}
