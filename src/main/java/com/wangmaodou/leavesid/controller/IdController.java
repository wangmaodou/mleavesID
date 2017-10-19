package com.wangmaodou.leavesid.controller;

import com.wangmaodou.leavesid.core.IdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maodou on 2017/10/19.
 */
@RestController
public class IdController {

    @Autowired
    IdFactory idFactory;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public long getId(){
        System.out.println("====getId====");
        return idFactory.create();
    }
}
