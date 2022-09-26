package org.study;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.entities.Dlb;
import org.study.service.DlbService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestLoginService {
    @Autowired
    private DlbService loginService;

    public TestLoginService() {
    }

    @Test
    public void a() {
        LambdaQueryWrapper<Dlb> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(StringUtils.isNotBlank("123"), Dlb::getName, "123")
                .eq(StringUtils.isNotBlank("123"), Dlb::getPassword, "123");
        Dlb one = (Dlb) this.loginService.getOne(queryWrapper);
        System.out.println(one.getName());
    }
}