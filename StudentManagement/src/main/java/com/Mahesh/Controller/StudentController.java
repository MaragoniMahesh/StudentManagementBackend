package com.Mahesh.Controller;

import com.Mahesh.Service.IStudentService;
import com.Mahesh.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080/")
public class StudentController {
      @Autowired
      private IStudentService iStudentService;

    @PostMapping("/Student")
    public Student registerStudent(@RequestBody Student s){
          iStudentService.saveStudent(s);
        return s;
    }
    @GetMapping("/Students")
    public List<Student> getAllStudents(){
        List<Student> list = iStudentService.getAllStudent();
        return list;
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentbyId(@PathVariable Long id){
        Student stu = iStudentService.getStudentById(id);
        return  ResponseEntity.ok(stu);
    }

  @DeleteMapping("/Student/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable Long id){
      iStudentService.deleteStudentById(id);
      return ResponseEntity.noContent().build();
    }
    @PutMapping("/Student/{id}")
   public Student updateStudent(@RequestBody Student s , @RequestParam Long id){
      Student student = iStudentService.getStudentById(id);
      student.setName(s.getName());
      student.setEmail(s.getEmail());
      student.setPhoneNumber(s.getPhoneNumber());
      student.setAddress(s.getAddress());
      student.setId(s.getId());
      student.setCountry(s.getCountry());
      student.setPassword(s.getPassword());
      iStudentService.saveStudent(student);
      return student;
   }
}
