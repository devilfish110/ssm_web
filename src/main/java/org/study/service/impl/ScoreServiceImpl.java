package org.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.study.entities.Score;
import org.study.mapper.ScoreMapper;
import org.study.service.ScoreService;

/**
 * @author TAO
 * @description 针对表【score】的数据库操作Service实现
 * @createDate 2022-09-01 21:39:47
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
        implements ScoreService {

}




