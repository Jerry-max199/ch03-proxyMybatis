package com.zzjm.dao;

import com.zzjm.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudent();
    int insertStudent(Student student);
}
