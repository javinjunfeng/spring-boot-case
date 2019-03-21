package top.javinjunfeng.service;

import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/20 1:04 PM
 */
public interface BaseService<T> {

    T selectById(Object key);

    int save(T entity);

    int insertNotNull(T entity);

    int delete(Object key);

    int update(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    Condition createCondition();
}
