package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.dao.HotelMapper;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.service.HotelService;
import cn.bdqn.itrip.tools.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 酒店业务实现类
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Resource
    private HotelMapper hotelMapper;

    /**
     * 增加酒店
     * @param hotel
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean add(Hotel hotel) {
        int i = hotelMapper.add(hotel);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     *根据酒店名  城市id  房间退房时间 模糊分页查询
     * @param hotelName
     * @param cId
     * @param checkinTime
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PageBean<Hotel> findByHotelNameAndCIdAndCheckoutTime(String hotelName, Integer cId, Date checkinTime, int pageIndex, int pageSize) {
        int count = hotelMapper.getCountByHotelNameAndCIdAndCheckoutTime(hotelName, cId, checkinTime);
        PageBean<Hotel> pageBean=new PageBean<Hotel>(pageSize,count);
        if (count>0){
            pageBean.setPageIndex(pageIndex);
            int startRow = pageBean.getStartRow();
            List<Hotel> hotelList = hotelMapper.getByHotelNameAndCIdAndCheckoutTime(hotelName, cId, checkinTime, startRow, pageSize);
            pageBean.setList(hotelList);
            return pageBean;
        }else {
            return pageBean;
        }
    }
}
