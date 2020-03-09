package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping(value ="/student")
public class StudentController {
    public StudentController() {
    }

    IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    //    @GetMapping(value ="/student/list") // means request mapping
    @RequestMapping("/student/list")
    public ModelAndView listStudents() {
        ModelAndView modelandview = new ModelAndView();
        List<Student> students = studentService.getStudents();
        modelandview.addObject("students", students);
        modelandview.addObject("studentCount", students.size());
        modelandview.setViewName("student/list");
        return modelandview;
    }

    @GetMapping(value = {"/student/new"})
    public String addStudentsForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping("/student/new")
    public String addStudent(@Valid Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/student/new";
        }

        Student stud = studentService.saveStudent(student);
        model.addAttribute("student", stud);
        return "redirect:/student/list";
    }

    @GetMapping(value = "edit/{studentId}")
    public String editStudent(@PathVariable("studentId") long id, Model model) {
        Student student = studentService.findStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Student Id:" + id));

        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping(value = "/update/{studentId}")
    public String updateStudentData(@PathVariable("studentId") long studentId, @Valid Student student, BindingResult result, Model model) {
        if(result.hasErrors()){
            student.setStudentId(studentId);
            return "student/edit";
        }
        student =studentService.saveStudent(student);
        model.addAttribute("student",student);
        return "redirect:/student/list";
    }



    @GetMapping("/delete/{studentId}")
    public String deleteUser(@PathVariable("studentId") long studentId, Model model) {
        Student student = studentService.findStudentById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Student Id:" + studentId));
        studentService.deleteStudent(student);
        List<Student> students = studentService.getStudents();
        model.addAttribute("student", students);
        return "student/list";
    }
}
