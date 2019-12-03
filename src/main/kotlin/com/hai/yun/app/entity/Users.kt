package com.hai.yun.app.entity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource


//用户模块

data class User(
    var _id: Int?,
    var userName: String?,
    var userPassword: String?,
    var sex: String?,
    var address: String?
)

//用户mapper映射

interface UserMapper : BaseMapper<User> {

}

interface UserService : IBaseService<User> {

}

//注意这个注解要使用allopen插件
@Service
class UserServiceImp : BaseServiceImpl<User>, UserService {

    constructor()

    @Resource
    lateinit var mapper: UserMapper

    override fun getMapper(): BaseMapper<User> {
        return mapper
    }


}


@Controller
@RequestMapping("/user")
class UserController {


    var userService: UserService

    @Autowired
    constructor(userServiceImp: UserServiceImp) {
        this.userService = userServiceImp
    }


    @PostMapping
    fun save(user: User): String {
        userService.save(user)
        return "save success"
    }

    //使用get方法查询
    @GetMapping("/getUser")
    @ResponseBody
    fun list(): List<User> {
        val list = userService.list()
        println(list)
        return list
    }
}