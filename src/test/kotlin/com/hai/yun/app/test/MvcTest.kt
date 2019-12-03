package com.hai.yun.app.test

import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print


@RunWith(value = SpringRunner::class)
@SpringBootTest(classes = arrayOf(SpringBootApplication::class))
// 定义单元测试执行顺序，采取测试用例名称升序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MvcTest {


    @Autowired
    val webApplicationwebApplication: WebApplicationContext?=null
    private var mockMvc: MockMvc? = null
    @Before
    fun init(){
        mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationwebApplication ).build()
    }

    //查询
    @Test
    fun query(){
        mockMvc?.perform(MockMvcRequestBuilders
            .get("/user")
            .contentType(MediaType.APPLICATION_JSON)

        )?.andExpect(MockMvcResultMatchers.status().isOk())
            ?.andDo(print());

    }
}