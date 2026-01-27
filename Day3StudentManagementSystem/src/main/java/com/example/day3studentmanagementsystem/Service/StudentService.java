package com.example.day3studentmanagementsystem.Service;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
    //Display Students
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    public StudentModel getStudent(String id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("No student found"));
    }

    public void deleteModel(String id){
        repository.deleteById(id);
    }

    //update
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent=repository.findById(id).orElseThrow(()-> new RuntimeException("No student found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }
}