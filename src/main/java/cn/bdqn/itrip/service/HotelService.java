package cn.bdqn.itrip.service;

import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.tools.PageBean;

import java.util.Date;
import java.util.List;

/**
 * 酒店业务接口
 */
public interface HotelService {
    /**
     * 增加酒店
     * @param hotel
     * @return
     */
    boolean add(Hotel hotel);
    /**
     *根据酒店名  城市id  房间退房时间 模糊分页查询
     * @param hotelName
     * @param cId
     * @param checkinTime
     * @return
     */
    PageBean<Hotel> findByHotelNameAndCIdAndCheckoutTime(String hotelName,
                                                         Integer cId,
                                                         Date checkinTime,
                                                         int pageIndex,
                                                         int pageSize);
}
