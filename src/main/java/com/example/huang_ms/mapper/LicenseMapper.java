package com.example.huang_ms.mapper;

import com.example.huang_ms.domain.License;
import com.example.huang_ms.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LicenseMapper {
    List<License> queryLicenseList();
    License queryLicenseById(Integer id);
    int addLicense(License license);
    int updateLicense(License license);
    int deleteLicense(Integer id);
}
