package org.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.study.entities.Course;
import org.study.mapper.CourseMapper;
import org.study.service.CourseService;

/**
 * @author TAO
 * @description 针对表【course】的数据库操作Service实现
 * @createDate 2022-09-01 21:39:56
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {

}




