package com.learn.student.service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.learn.student.entity.Student;
import com.learn.student.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
 
@Service
public class studentService {
 
   private final StudentRepository studentRepository;
 
   public studentService(StudentRepository studentRepository) {
       this.studentRepository = studentRepository;
   }
 
   public Student saveStudent(Student student) {
       return studentRepository.save(student);
   }
 
   public List<Student> getAllStudents() {
       return studentRepository.findAll();
   }
 
   public Student getStudentById(int id) {
       return studentRepository.findById(id).orElse(null);
   }
 
   public void deleteStudent(int id) {
       studentRepository.deleteById(id);
   }

    

    public Student updateStudent(int id, Student updatedStudent) {
       Student existingStudent = studentRepository.findById(id).orElse(null);
       if(existingStudent != null) {
           existingStudent.setStudentName(updatedStudent.getStudentName());
           return studentRepository.save(existingStudent);
       } else {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
       }
   }
}