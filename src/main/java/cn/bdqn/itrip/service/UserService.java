package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.User;

/**
 * 用户业务接口
 */
public interface UserService {
    /**
     * 根据账号和密码查询特定用户
     * @param userCode
     * @param userPassword
     * @return
     */
    User findByUserCodeAndUserPassword(String userCode,String userPassword);
    /**
     * 增加用户
     * @param user
     * @return
     */
    boolean add(User user);
}
