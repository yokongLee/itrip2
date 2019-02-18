package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.City;

import java.util.List;

/**
 * 城市实体类
 */
public interface CityMapper {
    /**
     * 查询所有城市
     * @return
     */
    List<City> getAll();
}
