package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.City;
import cn.bdqn.itrip.pojo.Hotel;
import cn.bdqn.itrip.service.CityService;
import cn.bdqn.itrip.service.HotelService;
import cn.bdqn.itrip.tools.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Resource
    private HotelService hotelService;
    @Resource
    private CityService cityService;


    /**
     * 请求后台增加酒店页面
     * @return
     */
    @RequestMapping("/addHotel")
    public String addHotel(){
        return "back/addHotel";
    }
    /**
     * 增加酒店
     * @return
     */
    @RequestMapping("/doAddHotel")
    public String addVersionSave(Hotel hotel,
                                 HttpServletRequest request,
                                 HttpSession session,
                                 @RequestParam(value = "a_image") MultipartFile attach){

        //文件上传
        String a_logoPicPath=null;
        if (!attach.isEmpty()){
            //上传路径
            //String path=session.getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
            String path="C:\\Users\\Lee\\IdeaProjects\\itrip\\src\\main\\resources\\static\\uploadfiles";

            System.out.println(path+"++++++++++++++++++++++++++++++++++++++++");
            //原文件名
            String oldFileName=attach.getOriginalFilename();


            //后缀
            String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));

            if (attach.getSize()>500000000){
                request.setAttribute("fileUploadError","上传的文件太大了");
                return "dev/appinfoadd";
            }else if (suffix.equalsIgnoreCase(".jpg")
                    ||suffix.equalsIgnoreCase(".png")
                    ||suffix.equalsIgnoreCase(".jpeg")){
                //新文件名
                String filename=UUID.randomUUID() + suffix;
                //入参
                hotel.setImage("/static/uploadfiles/"+filename);

                File targetFile = new File(path, filename);
                //判断文件父目录是否存在
                if (!targetFile.getParentFile().exists()){
                    targetFile.getParentFile().mkdirs();
                }
                try {
                    //保存
                    attach.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                request.setAttribute("fileUploadError","格式不正确");
                return "back/addHotel";
            }
        }

        boolean b = hotelService.add(hotel);
        if (b){
            return "redirect:/hotel/index";
        }

        request.setAttribute("fileUploadError","增加失败");
        return "back/addHotel";
    }

    /**
     * 请求主页面
     * 根据酒店名  城市id  房间退房时间 模糊分页查询
     * @return
     */
    @RequestMapping("/index")
    public String hotelList(HttpServletRequest request,
                              @RequestParam(value = "hotelName",required = false) String hotelName,
                              @RequestParam(value = "cId",required = false) Integer cId,
                              @RequestParam(value = "checkinTime",required = false) Date checkinTime,
                              @RequestParam(value = "checkoutTime",required = false)Date checkoutTime,
                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "1")Integer pageSize){
        PageBean<Hotel> pageBean = hotelService.findByHotelNameAndCIdAndCheckoutTime(hotelName, cId, checkinTime, pageIndex, pageSize);
        if (pageBean!=null){
            request.setAttribute("pageBean",pageBean);
        }
        //加载酒店所属城市
        List<City> cityList = cityService.findAll();
        request.setAttribute("cityList",cityList);

        //保存查询条件
        if (hotelName!=null&&!hotelName.equals("")){
            request.setAttribute("hotelName",hotelName);
        }
        if (cId!=null){
            request.setAttribute("cId",cId);
        }
        if (checkinTime!=null){
            request.setAttribute("checkinTime",new SimpleDateFormat("yyyy-MM-dd").format(checkinTime));
        }
        if (checkoutTime!=null){
            request.setAttribute("checkoutTime",new SimpleDateFormat("yyyy/MM/dd").format(checkoutTime));
        }


        return "index";
    }
}
