package org.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;
import org.study.entities.Dlb;
import org.study.entities.Result;

/**
 * @author TAO
 * @description 针对表【dlb】的数据库操作Service
 * @createDate 2022-09-01 21:39:52
 */
@Transactional(rollbackFor = Exception.class)
public interface DlbService extends IService<Dlb> {
    public Result login(Dlb user);
}
