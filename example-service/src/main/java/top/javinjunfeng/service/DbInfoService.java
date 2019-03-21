package top.javinjunfeng.service;

import top.javinjunfeng.example.dao.entity.DbInfo;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/20 1:04 PM
 */
public interface DbInfoService extends BaseService<DbInfo>{

    /**
     * 根据数据源编码查询数据库连接信息
     * @param dbCode 数据源编码
     * @return
     */
    DbInfo selectByDbCode(String dbCode);
}
