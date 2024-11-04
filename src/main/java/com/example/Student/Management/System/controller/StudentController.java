package com.example.Student.Management.System.controller;

import com.example.Student.Management.System.model.Student;
import com.example.Student.Management.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.saveStudent(student),
   HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudent(){
    return studentService.getAllStudent();
    }
    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<Student> getEmployeeById(@PathVariable("id") long studentID){
    return new ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
    }
    //Update Rest Api
    @PutMapping("{id}")
 public ResponseEntity<Student> updateEmployee(@PathVariable("id") long
id,
 @RequestBody Student student){
 return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
 }
 //Delete Rest Api
 @DeleteMapping("{id}")
 public ResponseEntity<String> deleteEmployee(@PathVariable("id") long
id){
 //delete employee from db
 studentService.deleteStudent(id);
 return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
 }
}

   

