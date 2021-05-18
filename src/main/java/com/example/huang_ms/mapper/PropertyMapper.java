package com.example.huang_ms.mapper;

import com.example.huang_ms.domain.Property;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PropertyMapper {
    List<Property> queryPropertyList();
    Property queryPropertyById(int id);
    void addProperty(Map params);
    int deleteProperty(int id);
    //查询其他表
    List<String> queryLicenseCodeList();
    List<String> queryProjectList();
}
