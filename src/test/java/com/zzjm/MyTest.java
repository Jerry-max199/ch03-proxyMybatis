package com.zzjm;

import com.zzjm.dao.StudentDao;
import com.zzjm.domain.Student;
import org.apache.ibatis.session.SqlSession;
import com.zzjm.Utils.*;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void ProxyselelctStudent() {
        /**
         * 使用mybatis的动态代理机制，使用sqlSession.getMapper(Dao接口)
         * getMapper能够获取dao接口对于实现类的对象。
         */
        SqlSession sqlSession=MyUtils.getSqlsession();
        StudentDao studentDao=sqlSession.getMapper(StudentDao.class);
        List<Student> studentList=studentDao.selectStudent();
        for (Student student:studentList){
            System.out.println(student);
        }
    }
    @Test
    public void ProxyInsertStudent(){
        SqlSession sqlSession=MyUtils.getSqlsession();
        StudentDao studentDao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("zhans");
        student.setId(1010);

      int num=  studentDao.insertStudent(student);
        sqlSession.commit();
      sqlSession.close();
        System.out.println(num);
    }
}
