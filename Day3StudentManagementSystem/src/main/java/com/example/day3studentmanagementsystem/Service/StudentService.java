package com.example.day3studentmanagementsystem.Service;

import com.example.day3studentmanagementsystem.DTO.StudentRequestDto;
import com.example.day3studentmanagementsystem.DTO.StudentResponseDto;
import com.example.day3studentmanagementsystem.Exception.StudentNotFoundException;
import com.example.day3studentmanagementsystem.Model.StudentModel;
import com.example.day3studentmanagementsystem.Repository.StudentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }
    //display post
    public StudentResponseDto addStudent(StudentRequestDto dto){
        //why do we need two object
        StudentModel student=new StudentModel(); //server
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved=repository.save(student); //client
        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    //Display Students
//    public List<StudentModel> getStudents(){
//        return repository.findAll();
//    }
//
//    public StudentModel getStudent(String id){
//        return repository.findById(id).orElseThrow(()-> new RuntimeException("No student found"));
//    }
//
    public void deleteModel(String id){
        if(!repository.existsById(id)){
            throw new StudentNotFoundException(("Student Not Found"));
        }
        repository.deleteById(id);
    }

    //get
    public List<StudentResponseDto> getStudents(){
        return repository.findAll()
        .stream().map(studentModel -> new StudentResponseDto(
                   studentModel.getId(),
                        studentModel.getName(),
                        studentModel.getAge(),
                        studentModel.getEmail()
                )).toList();
    }

    //update
    public StudentResponseDto updateStudent(String id,StudentRequestDto student){
        StudentModel existingStudent=repository.findById(id).orElseThrow(()-> new StudentNotFoundException("No student found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        StudentModel savedStudent=repository.save(existingStudent);
        return new StudentResponseDto(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getAge(),
                savedStudent.getEmail()
        );
    }
}