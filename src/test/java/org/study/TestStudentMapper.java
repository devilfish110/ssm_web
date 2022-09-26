package org.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.entities.Dlb;
import org.study.entities.Result;
import org.study.entities.Student;
import org.study.mapper.StudentMapper;
import org.study.service.DlbService;
import org.study.utils.birthdayUtil;

import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestStudentMapper {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DlbService dlbService;

    @Test
    public void testAll() {
        List<Student> studentList = studentMapper.selectList(null);
        Student student = studentList.get(2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = format.format(student.getBirthday());
        System.out.println(student.getBirthday());
        System.out.println(student.getStudentName() + "的出生时间:" + birthday);
        System.out.println("============");
        System.out.println(birthdayUtil.timeFormat(student.getBirthday()));
    }

    @Test
    public void testA() {
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);
    }

    @Test
    public void testB() {
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);
    }

    @Test
    public void testS() {
        Dlb dlb = new Dlb(1, "123", "123");
        Result result = dlbService.login(dlb);
        System.out.println(result);
    }
}
