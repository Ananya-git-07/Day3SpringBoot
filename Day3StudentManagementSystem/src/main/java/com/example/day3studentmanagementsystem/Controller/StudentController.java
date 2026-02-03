package com.example.day3studentmanagementsystem.Controller;

import com.example.day3studentmanagementsystem.DTO.StudentRequestDto;
import com.example.day3studentmanagementsystem.DTO.StudentResponseDto;
import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @PostMapping("/add-student")
//    public StudentModel addStudent(@RequestBody StudentModel student){
//        return service.addStudent(student);
//    }
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
     }

    @GetMapping("/students")
//    public List<StudentModel> getStudents(){
//        return service.getStudents();
//    }
    public List<StudentResponseDto> getStudents(){
        return service.getStudents();
    }

//    @GetMapping("/student/{id}")
//    public StudentModel getStudent(@PathVariable String id){
//        return service.getStudents(id);
//    }

    @DeleteMapping("/student/{id}")
    public void deleteModel(@PathVariable String id){
        service.deleteModel(id);
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,@Valid @RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }
}