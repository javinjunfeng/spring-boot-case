package top.javinjunfeng.springboot.redis.service;

public interface CompanyService {
    /**
     * 获取公司值
     *
     */
    Integer isCompany(String companyName);

    Integer add();

    Integer del();

    void set(String key, String value);

    String get(String key);
}
