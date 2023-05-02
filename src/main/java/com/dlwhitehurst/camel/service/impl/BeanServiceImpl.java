package com.dlwhitehurst.camel.service.impl;

import com.dlwhitehurst.camel.model.MyBean;
import com.dlwhitehurst.camel.service.BeanService;
import org.springframework.stereotype.Service;

@Service("beanService")
public class BeanServiceImpl implements BeanService {

    @Override
    public void createBean(MyBean mybean) {
        System.out.println("id is: " + mybean.getId());
        System.out.println("name is: " + mybean.getName());

    }
}
