package com.springboot.dao;

import com.springboot.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @param
 * @param
 * @param
 * @author
 * @Title:
 * @Description:
 * @return
 * @date 2019/9/9 10:16
 * @throws
 */
public interface StudentDao {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    List<Map<String,Object>> queryStudentsListMap();
    Student queryStudentBySno(String sno);
}
