package com.learn.student.studentcontroller;
 
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.learn.student.entity.Student;
import com.learn.student.service.studentService;
 
@RestController
@RequestMapping("/api/students")
public class studentController {
 
   private final studentService studentService;
 
   public studentController(studentService studentService) {
       this.studentService = studentService;
   }
 
   @PostMapping
   public Student addStudent(@RequestBody Student student) {
       return studentService.saveStudent(student);
   }
 
   @GetMapping
   public List<Student> getAllStudents() {
       return studentService.getAllStudents();
   }
 
   @GetMapping("/{id}")
   public Student getStudent(@PathVariable int id) {
       return studentService.getStudentById(id);
   }
 
   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable int id) {
 
       studentService.deleteStudent(id);
 
       return "Student deleted successfully";
   }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
        @PathVariable int id,
        @RequestBody Student student) {
    
    Student updatedStudent = studentService.updateStudent(id, student);
    
    if (updatedStudent != null) {
        return ResponseEntity.ok(updatedStudent);
    }
    
    return ResponseEntity.notFound().build();
    }
   
}
