package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户到接口
 */
public interface UserMapper {
    /**
     * 根据账号和密码查询特定用户
     * @param userCode
     * @param userPassword
     * @return
     */
    User getByUserCodeAndUserPassword(@Param("userCode") String userCode,@Param("userPassword") String userPassword);

    /**
     * 增加用户
     * @param user
     * @return
     */
    int add(User user);
}
