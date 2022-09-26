package org.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.entities.Student;
import org.study.mapper.StudentMapper;
import org.study.service.StudentService;

import java.util.List;

/**
 * @author TAO
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2022-09-01 21:38:50
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStu() {
        return studentMapper.selectList(null);
    }

    @Override
    public Boolean addOneStudent(Student student) {
        int i = studentMapper.insert(student);
        return i > 0;
    }

    @Override
    public Boolean delOneStudent(Student student) {
        LambdaUpdateWrapper<Student> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Student::getStudentId, student.getStudentId())
                .or()
                .eq(StringUtils.isNotBlank(student.getStudentName()), Student::getStudentName, student.getStudentName());
        int i = studentMapper.delete(updateWrapper);
        return i > 0;
    }

    @Override
    public Boolean updateStudent(Student student) {
        int i = studentMapper.updateById(student);
        return i > 0;
    }

}




