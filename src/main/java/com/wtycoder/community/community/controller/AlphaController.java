package com.wtycoder.community.community.controller;

import com.wtycoder.community.community.service.AlphaService;
import com.wtycoder.community.community.util.CommunityUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello SpringBoot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        // get request
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " "+ value);
        }
        System.out.println(request.getParameter("code"));

        // get response data
        response.setContentType("text/html;charset=utf-8");
        try(
                PrintWriter writer = response.getWriter();
                )
        {

            writer.write("<h1>niuke</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // GET request
    // 分页查询
    //  /students?current=1&limit=20
    @RequestMapping(path="/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name="current",required = false,defaultValue = "1") int current,
                              @RequestParam(name="limit",required = false,defaultValue = "10") int limit)
    {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    // 根据id查询，成为路径一部分
    // /students/123
    @RequestMapping(path="/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    // POST Request
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // respond with HTML data
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "zhangsan");
        mav.addObject("age",30);
        // in templates folder
        mav.setViewName("/demo/view");
        return mav;
    }

    // same as above
    @RequestMapping(path="/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","peking university");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    // Respond to JSON data(async request)
    @RequestMapping(path="/emp", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmp(){
        List<Map<String,Object>> list = new ArrayList<>();

        Map<String,Object> emp = new HashMap<>();
        emp.put("name","zhangsan");
        emp.put("age",23);
        emp.put("salary",8000.00);
        list.add(emp);
        return list;
    }


    // Ajax 示例
    @RequestMapping(path = "/ajax", method = RequestMethod.POST)
    @ResponseBody
    public String testAjax(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return CommunityUtil.getJSONString(0,"operation success");

    }


}
