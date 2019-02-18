package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.City;

import java.util.List;

/**
 * 城市业务接口
 */
public interface CityService {
    /**
     * 查询所有城市
     * @return
     */
    List<City> findAll();
}
