package top.javinjunfeng.service;

import top.javinjunfeng.model.entity.DbInfoDO;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/19 10:28 AM
 */
public interface DbInfoService {
    /**
     * 查询数据编码连接信息
     * @param dbCode
     * @return
     */
    DbInfoDO select(String dbCode);
}
