package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.IStudentService;

@Component
@RequestMapping("/home")
public class HelloController {

    /*Cach 1: Di qua Interface*/
    @Autowired
    private IStudentService studentService;

    /*Cach 2: Di qua constructor*/
//    public HelloController(IStudentService studentService) {
//        this.studentService = studentService;
//    }


    /*Cach 3: Di qua setter*/
//    @Autowired
//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }

//    @RequestMapping(
//            value = {"/hello","/home"},
//            method = RequestMethod.GET,
//            consumes = "application/json",
//            produces = "application/json"
//    )
    @GetMapping(
            value = {"/hello","/home"}
//            consumes = "application/json",
//            produces = "application/json"
    )
    public String getHelloPage(Model model,
                               ModelMap modelMap,
                                /*Khai bao đây đủ*/
//                               @RequestParam(value = "name") String studentName,
//                               @RequestParam(value = "age") int studentAge){
                               /*Viết rút gọn, lưu ý: tên biến local trùng với tên key*/
                                @RequestParam(required = false, defaultValue = "no name") String name,
                               @RequestParam(required = false, defaultValue = "-1") Integer age){


        /*gởi dữ liệu - data*/
        model.addAttribute("studentName", name);
        modelMap.addAttribute("studentAge", age);



        /*trả về tên view*/
        return "hello";
//        model.addAttribute("display", false);
//        return "list";
    }

    @GetMapping(value = "/student")
    public ModelAndView getStudentList(Model model){
        /*Cách 1*/
//        List<Student> studentList = studentService.findAll();
//
//        ModelAndView modelAndView = new ModelAndView("list");
//        modelAndView.addObject("studentList", studentList);

//        return modelAndView;

        model.addAttribute("display", true);
        /*Cách 2*/
        return  new ModelAndView("list","studentList", studentService.findAll());
    }

    @GetMapping("/student/{id:[1-5]}/edit")
    public String editStudent(Model model,
                              @PathVariable(value = "id") int studentID){

        System.err.println(studentID);

        /*gởi dữ liệu - data*/
        model.addAttribute("studentName", "Nguyen Van A");
        model.addAttribute("studentAge", 55);

        /*trả về tên view*/
        return "hello";
//        model.addAttribute("display", false);
//        return "list";
    }

    @GetMapping("/student/edit/")
    public String editStudent1(Model model,
                              @RequestParam(value = "id") int studentID){

        System.err.println(studentID);

        /*gởi dữ liệu - data*/
        model.addAttribute("studentName", "Nguyen Van A");
        model.addAttribute("studentAge", 55);

        /*trả về tên view*/
        return "hello";
//        model.addAttribute("display", false);
//        return "list";
    }

    /*Phương thức bình thường*/
    private void abc(){

    }
}