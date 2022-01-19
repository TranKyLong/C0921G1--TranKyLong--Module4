package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /*
    Nhận request của người dùng
    và trả về 1 cái form
    */
    @GetMapping("/create")
    public String showCreatePage(Model model) {

        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("JAVA");
        languageList.add("PHP");

//       /*Nem doi tuong rong, khi tao moi*/
        Student student = new Student();

        /*truong hop edit thì ném về fomr một đối tượng có dữ liệu.*/
//        Student student = new Student(11,"Tai",2, new String[]{"JAVA"});
        model.addAttribute(student);

        model.addAttribute("languageList", languageList);

        return "student/create";
    }

    /*Nhận kết quả của form và lưu về server*/
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes) {
        studentService.save(student);

        /*chuyển hướng với redirect có kèm data, lưu ý data chỉ tồn tại ở 1 request.*/
        redirectAttributes.addFlashAttribute("successMS",
                "Create student: " + student.getName()+ " OK!");
        return "redirect:/student/list"; //chuyển hướng không kèm data
//        return "forward:/student/list"; //chuyển hướng kèm data
    }

//    @PostMapping(value = "/list")
//    public ModelAndView getStudentList(Model model) {
//        return new ModelAndView("student/list", "studentList", studentService.findAll());
//
//    }

    @GetMapping(value = "/list")
    public ModelAndView getStudentList(Model model) {
        return new ModelAndView("student/list", "studentList",
                studentService.findAll());

    }

    @GetMapping("/edit/{index}")
    public String showEditForm(@PathVariable int index, Model model){
        Student student = studentService.findByIndex(index);
        model.addAttribute("student", student);

        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("JAVA");
        languageList.add("PHP");
        model.addAttribute("languageList", languageList);

        return "/student/edit";
    }

    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes){
        studentService.save(student);

        /*chuyển hướng với redirect có kèm data, lưu ý data chỉ tồn tại ở 1 request.*/
        redirectAttributes.addFlashAttribute("successMS",
                "Update student: " + student.getName()+ " OK!");
        return "redirect:/student/list"; //chuyển hướng không kèm data
    }
}
