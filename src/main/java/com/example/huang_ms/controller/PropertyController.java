package com.example.huang_ms.controller;

import com.example.huang_ms.domain.Property;
import com.example.huang_ms.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PropertyController {
    @Autowired
    private PropertyMapper propertyMapper;
    //展示资产信息
    @GetMapping("/view/property")
    public String queryPropertyList(Model model){
        List<Property> propertyList = propertyMapper.queryPropertyList();
        model.addAttribute("properties",propertyList);
        return "view/propertylist";
    }
    //    添加操作
    @GetMapping("/view/add_property")
    public String addProperty(Model model){
        List<String> license_code_list = propertyMapper.queryLicenseCodeList();
        List<String> project_name_list = propertyMapper.queryProjectList();
        model.addAttribute("licenses",license_code_list);
        model.addAttribute("projects",project_name_list);
        return "view/addproperty";
    }
    @PostMapping("/addproperty")
    public String addLicense(@RequestParam("license_code")String license_code,
                             @RequestParam("mac_address")String mac_address,
                             @RequestParam("ip_address")String ip_address,
                             @RequestParam("project_name")String project_name){
        Map params = new HashMap<>();
        params.put("license_code",license_code);
        params.put("mac_address",mac_address);
        params.put("ip_address",ip_address);
        params.put("project_name",project_name);
        propertyMapper.addProperty(params);
        return  "redirect:/view/property";
    }
    //property不允许修改，故无修改操作
    //删除操作
    @RequestMapping("/deleteproperty/{id}")
    public String deleteLicense(@PathVariable("id")int id){
        propertyMapper.deleteProperty(id);
        return "redirect:/view/property";
    }
}
