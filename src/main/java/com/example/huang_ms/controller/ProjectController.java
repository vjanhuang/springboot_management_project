package com.example.huang_ms.controller;

import com.example.huang_ms.domain.Project;
import com.example.huang_ms.mapper.ProjectMapper;
import com.example.huang_ms.service.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private DateConverter dateConverter;
    //展示project面板
    @GetMapping("/view/project")
    public String queryProjectList(Model model) {
        List<Project> projectList = projectMapper.queryProjectList();
        model.addAttribute("projects",projectList);
        return "view/projectlist";
    }
    //添加操作
    @GetMapping("/view/add_project")
    public String add_project(){
        return "view/addproject";
    }
    @PostMapping("/addproject")
    public String addproject(@RequestParam("leader_name")String leader_name,
                             @RequestParam("project_name")String project_name,
                             @RequestParam("login_date") String login_date){
//        Project project = new Project(-1,project_name,null,null,null,login_date);
        Date login_date_format = dateConverter.convert(login_date);
        projectMapper.addProject(project_name,login_date_format,leader_name);
        return "redirect:/view/project";
    }
    //删除操作
    @RequestMapping("/deleteproject/{id}")
    public String deleteUserList(@PathVariable("id")int id){
        projectMapper.deleteProject(id);
        return "redirect:/view/project";
    }
    //改动操作
    @RequestMapping("/view/update_project/{id}")
    public String update_project(@PathVariable("id")int id,Model model){
        Project project = projectMapper.queryProjectById(id);
        model.addAttribute("project",project);
        return "view/updateproject";
    }
    @PostMapping("/updateproject")
    public String updateProjectList(@RequestParam("id")int id,
                                 @RequestParam("project_name")String project_name,
                                 @RequestParam("login_date")Date login_date){
        projectMapper.updateProject(id,project_name,login_date);
        return "redirect:/view/project";
    }
}
