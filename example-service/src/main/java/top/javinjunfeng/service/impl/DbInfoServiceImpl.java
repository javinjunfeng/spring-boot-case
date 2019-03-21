package top.javinjunfeng.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import top.javinjunfeng.example.dao.entity.DbInfo;
import top.javinjunfeng.service.BaseServiceImpl;
import top.javinjunfeng.service.DbInfoService;

import java.util.List;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/20 1:05 PM
 */
@Service
public class DbInfoServiceImpl extends BaseServiceImpl<DbInfo> implements DbInfoService {

    /**
     * 根据数据源编码查询数据库连接信息
     * @param dbCode 数据源编码
     * @return
     */
    @Override
    public DbInfo selectByDbCode(String dbCode) {
        DbInfo dbInfo= new DbInfo();
        dbInfo.setDbCode(dbCode);

        return this.mapper.selectOne(dbInfo);
    }
}
