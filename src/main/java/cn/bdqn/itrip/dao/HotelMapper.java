package cn.bdqn.itrip.dao;

import cn.bdqn.itrip.pojo.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 酒店dao接口
 */
public interface HotelMapper {
    /**
     * 增加酒店
     * @param hotel
     * @return
     */
    int add(Hotel hotel);

    /**
     *根据酒店名  城市id  房间退房时间 模糊分页查询
     * @param hotelName
     * @param cId
     * @param checkinTime
     * @return
     */
    List<Hotel> getByHotelNameAndCIdAndCheckoutTime(@Param("hotelName") String hotelName,
                                                    @Param("cId") Integer cId,
                                                    @Param("checkinTime") Date checkinTime,
                                                    @Param("startRow") int startRow,
                                                    @Param("pageSize") int pageSize);
    /**
     *根据酒店名  城市id  房间退房时间 查询总数
     * @param hotelName
     * @param cId
     * @param checkinTime
     * @return
     */
    int getCountByHotelNameAndCIdAndCheckoutTime(@Param("hotelName") String hotelName,
                                                         @Param("cId") Integer cId,
                                                         @Param("checkinTime") Date checkinTime);

}
