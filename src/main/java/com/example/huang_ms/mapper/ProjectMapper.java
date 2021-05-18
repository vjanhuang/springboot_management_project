package com.example.huang_ms.mapper;

import com.example.huang_ms.domain.Project;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {
    List<Project> queryProjectList();
    Project queryProjectById(int id);
    int addProject(@Param("project_name") String project_name, @Param("login_date") Date login_date,@Param("leader_name") String leader_name);
    int updateProject(@Param("id")int id,@Param("project_name")String project_name,@Param("login_date")Date login_date);
    int deleteProject(int id);
}
