package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.UserMapper;
import cn.bdqn.itrip.pojo.User;
import cn.bdqn.itrip.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据账号和密码查询特定用户
     * @param userCode
     * @param userPassword
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findByUserCodeAndUserPassword(String userCode, String userPassword) {
        return userMapper.getByUserCodeAndUserPassword(userCode,userPassword);
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean add(User user) {
        int i = userMapper.add(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
