package top.javinjunfeng.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.javinjunfeng.model.entity.DbInfoDO;
import top.javinjunfeng.model.mapper.DbInfoDOMapper;
import top.javinjunfeng.service.DbInfoService;

/**
 * @Descriptoin:
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2019/3/19 10:29 AM
 */
@Service
public class DbInfoServiceImpl implements DbInfoService {
    @Autowired
    DbInfoDOMapper dbInfoDOMapper;

    /**
     * 查询数据编码连接信息
     * @param dbCode
     * @return
     */
    @Override
    public DbInfoDO select(String dbCode) {
        DbInfoDO dbInfoDO = dbInfoDOMapper.selectByDbCode(dbCode);
        return dbInfoDO;
    }
}
