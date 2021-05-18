package com.example.huang_ms.controller;

import com.example.huang_ms.domain.License;
import com.example.huang_ms.domain.User;
import com.example.huang_ms.mapper.LicenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LicenseController {
    @Autowired
    private LicenseMapper licenseMapper;
//    展示license面板
    @GetMapping("/view/license")
    public String queryLicenseList(Model model, HttpServletRequest request){
        List<License> licenseList = licenseMapper.queryLicenseList();
        model.addAttribute("licenses",licenseList);
        return "view/licenselist";
    }
//    添加操作
    @GetMapping("/view/add_license")
    public String addLicense(){
        return "view/addlicense";
    }
    @PostMapping("/addlicense")
    public String addLicense(@RequestParam("license_code")String license_code,
                             @RequestParam("license_version")String license_version,
                             @RequestParam("license_price")int license_price,
                             @RequestParam("validity")int validity){
        License license = new License(-1,license_code,license_version,license_price,validity);
        licenseMapper.addLicense(license);
        return  "redirect:/view/license";
    }
//    修改操作
    @RequestMapping("/view/update_license/{id}")
    public String update_user(@PathVariable("id")Integer id,Model model){
        License license = licenseMapper.queryLicenseById(id);
        model.addAttribute("license",license);
        return "view/updatelicense";
    }
    @PostMapping("/updatelicense")
    public String updateLicenseList(@RequestParam("id")int id,
                                    @RequestParam("license_code")String license_code,
                                    @RequestParam("license_version")String license_version,
                                    @RequestParam("license_price")int license_price,
                                    @RequestParam("validity")int validity){
        License license = new License(id,license_code,license_version,license_price,validity);
        licenseMapper.updateLicense(license);
        return "redirect:/view/license";
    }
//    删除操作
    @RequestMapping("/deletelicense/{id}")
    public String deleteLicense(@PathVariable("id")Integer id){
        licenseMapper.deleteLicense(id);
        return "redirect:/view/license";
    }
}
