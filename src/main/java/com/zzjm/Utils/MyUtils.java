package com.zzjm.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        String config="mybatis.xml";
        try {
            InputStream inputStream=Resources.getResourceAsStream(config);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            sqlSessionFactory= sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSqlsession(){
        SqlSession sqlSession=null;
        if (sqlSessionFactory!=null){
            sqlSession= sqlSessionFactory.openSession();
        }
        return sqlSession;
    }
}
