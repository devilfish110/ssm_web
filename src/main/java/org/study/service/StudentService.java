package org.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import org.study.entities.Student;

import java.util.List;

/**
 * @author TAO
 * @description 针对【学生】表的数据库操作Service
 * @createDate 2022-09-01 21:38:50
 */
@Transactional(rollbackFor = Exception.class)
public interface StudentService extends IService<Student> {

    List<Student> getAllStu();

    Boolean addOneStudent(Student student);

    Boolean delOneStudent(Student student);

    Boolean updateStudent(Student student);
}
