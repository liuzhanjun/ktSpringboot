package com.hai.yun.app

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource

//引入springIOC配置文件
@ImportResource(value = arrayOf("classpath:config.xml"))
@SpringBootApplication
//自动搜索指定包下的mapper接口
@MapperScan(basePackages = arrayOf("com.hai.yun.app.entity"))
open class MyApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MyApplication::class.java, *args)
        }
    }
}