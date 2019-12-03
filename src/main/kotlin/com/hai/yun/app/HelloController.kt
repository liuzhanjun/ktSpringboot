package com.hai.yun.app

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
@author liuzhanjun
 **/
@Controller
class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    fun hello(): String {
        return "hello world";
    }
}