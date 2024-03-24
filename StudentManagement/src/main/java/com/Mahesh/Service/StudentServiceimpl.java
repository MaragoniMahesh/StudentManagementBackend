package com.Mahesh.Service;

import com.Mahesh.Repositor.Studentrepo;
import com.Mahesh.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements IStudentService{
    @Autowired
    Studentrepo studentrepo;
    @Override
    public Student saveStudent(Student student) {
         studentrepo.save(student);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> list = studentrepo.findAll();
        return studentrepo.findAll();
    }

    @Override
    public Student getStudentById(Long Id) {
       Optional<Student> student = studentrepo.findById(Id);
       return student.get();
    }

    @Override
    public void deleteStudentById(Long Id) {
        studentrepo.deleteById(Id);
    }



}
