package org.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.entities.Dlb;
import org.study.entities.Result;
import org.study.mapper.DlbMapper;
import org.study.service.DlbService;

/**
 * @author TAO
 * @description 针对表【dlb】的数据库操作Service实现
 * @createDate 2022-09-01 21:39:52
 */
@Service
public class DlbServiceImpl extends ServiceImpl<DlbMapper, Dlb>
        implements DlbService {

    @Autowired DlbMapper dlbMapper;

    @Override
    public Result login(Dlb user) {
        Dlb dlb = dlbMapper.SelectOne(user);
        Result result = new Result();
        if (dlb==null){
            result.setStatus(404);
            result.setMessage("登陆失败!");
            return result;
        }else {
            result.setStatus(200);
            result.setMessage("登陆成功!");
            return result;
        }
    }
}




