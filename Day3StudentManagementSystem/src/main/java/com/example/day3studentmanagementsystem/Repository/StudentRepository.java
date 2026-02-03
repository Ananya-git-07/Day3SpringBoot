package com.example.day3studentmanagementsystem.Repository;

import com.example.day3studentmanagementsystem.Model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository  extends MongoRepository <StudentModel,String>{

}