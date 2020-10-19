package com.hai.yun.app.entity

import org.springframework.transaction.annotation.Transactional

interface BaseMapper<T> {
    /**
     * 保存
     */
    fun save(t: T): Int

    /**
     * 删除
     */
    fun delete(id: Int)

    /**
     * 通过id查询
     */
    fun findById(id: Int): T

    /**
     * 更新
     */
    fun update(t: T)

    /**
     * 返回所有信息
     */
    fun list(): List<T>
}

interface IBaseService<T>{

    /**
     * 保存
     */
    fun save(t: T): Int
    /**
     * 删除
     */
    fun delete(id: Int)

    /**
     * 通过id查询
     */
    fun findById(id: Int): T

    /**
     * 更新
     */
    fun update(t: T)

    /**
     * 返回所有信息
     */
    fun list(): List<T>

}

//添加事务
//该注解为每个方法添加事务，一般我们添加到方法上
@Transactional(rollbackFor = arrayOf(Throwable::class))
abstract class BaseServiceImpl<T> : IBaseService<T> {


    val baseMapper: BaseMapper<T> by lazy {
        getMapper()
    }

    abstract fun getMapper(): BaseMapper<T>

    override fun save(t: T): Int {
        return baseMapper.save(t)!!
    }

    override fun delete(id: Int) {
        baseMapper.delete(id)
    }

    override fun findById(id: Int): T {
        return baseMapper.findById(id)
    }

    override fun update(t: T) {
        baseMapper?.update(t)
    }

    override fun list(): List<T> {
        return baseMapper.list()
    }
}