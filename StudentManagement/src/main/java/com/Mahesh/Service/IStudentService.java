package com.Mahesh.Service;

import com.Mahesh.Student;

import java.util.List;

public interface IStudentService {
    public  Student saveStudent(Student student);

   public List<Student> getAllStudent();

   public Student getStudentById(Long Id);

   public void deleteStudentById(Long Id);



}
