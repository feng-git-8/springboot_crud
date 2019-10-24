package com.mr.springboot_crud.controller;

import com.mr.springboot_crud.entity.Crud;
import com.mr.springboot_crud.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://192.168.31.101:8080")
public class CrudController {

    @Autowired
    private ICrudService crudService;


    @RequestMapping("/ss")
    public String helloWorld(){
        return "helloWorld";
    }

    @RequestMapping(value = "index")
    public ModelAndView findCrudList(){
        List<Crud> list =  crudService.findCrudList();
        ModelAndView av = new ModelAndView("index");
        av.addObject("li",list);
        return av;

    }
    @ResponseBody
    @RequestMapping("/addCrud")
    public Map<String,Object> addCrud(Crud cr){
        int i = crudService.addCrud(cr);
        Map<String,Object> map = new HashMap<>();
        map.put("status",i);
        return map;
    }

    @ResponseBody
    @PostMapping("/deleteCrud")
    public Integer deleteCrud(Integer cid){
        int i = crudService.deleteCrud(cid);
        return i;
    }

    @ResponseBody
    @RequestMapping(value = "/updateCrud")
    public ModelAndView updateCrud(Integer cid, ModelMap mmp){
        Crud c = crudService.findOneCrud(cid);
        ModelAndView ma = new ModelAndView("upd");
        ma.addObject("cr",c);
        mmp.addAttribute("cr",c);
        return ma;
    }

    @ResponseBody
    @RequestMapping(value = "/updateCrudTrue")
    public Map<String,Object> updateCrudTrue(Crud cr){
        crudService.updateCrudTrue(cr);
        Map<String,Object> map = new HashMap<>();
        return map;
    }

    /**
     * 去添加页面
     */
    @ResponseBody
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView ma = new ModelAndView("add");
        return ma;
    }

    /* 测试更新项目*/
    public void test(){
        System.out.println("测试成功!");
    }


}
