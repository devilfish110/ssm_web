package org.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import org.study.entities.Score;

/**
 * @author TAO
 * @description 针对【成绩】表的数据库操作Service
 * @createDate 2022-09-01 21:39:47
 */
@Transactional(rollbackFor = Exception.class)
public interface ScoreService extends IService<Score> {

}
