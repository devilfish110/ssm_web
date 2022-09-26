package org.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.study.entities.Dlb;

/**
 * @author TAO
 * @description 针对表【dlb】的数据库操作Mapper
 * @createDate 2022-09-01 21:39:52
 * @Entity org.study.entities.Dlb
 */
@Mapper
public interface DlbMapper extends BaseMapper<Dlb> {
    public Dlb SelectOne(Dlb user);
}




