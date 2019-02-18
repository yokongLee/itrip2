package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.CityMapper;
import cn.bdqn.itrip.pojo.City;
import cn.bdqn.itrip.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 城市业务实现类
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    /**
     * 查询所有城市
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findAll() {
        return cityMapper.getAll();
    }
}
