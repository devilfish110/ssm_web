package org.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import org.study.entities.Course;

/**
 * @author TAO
 * @description 针对【课程】表的数据库操作Service
 * @createDate 2022-09-01 21:39:56
 */
@Transactional(rollbackFor = Exception.class)
public interface CourseService extends IService<Course> {

}
