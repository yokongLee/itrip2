package cn.bdqn.itrip.controller;

import cn.bdqn.itrip.pojo.User;
import cn.bdqn.itrip.service.MailService;
import cn.bdqn.itrip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private MailService mailService;

    /**
     * 请求登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(@RequestParam("userCode") String userCode,
                          @RequestParam("userPassword") String userPassword){
        User user = userService.findByUserCodeAndUserPassword(userCode, userPassword);
        //System.out.println(user.getUserName());
        Map map=new HashMap();
        if (user!=null){
           map.put("msg","success");
        }else {
            map.put("msg","用户名或密码错误！");
        }
        return map;
    }

    /**
     * 请求注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    /**
     * 注册
     * @return
     */
    @RequestMapping("/doRegister")
    @ResponseBody
    public Object doRegister(@RequestParam("userCode") String userCode,
                          @RequestParam("userPassword") String userPassword,
                          @RequestParam("userName") String userName,
                          HttpSession session){
        Map map=new HashMap();
        try {
            //保存信息
            User user=new User(userCode,userPassword,userName);
            session.setAttribute("user",user);

            System.out.println(userCode);
            //激活码
            Random random = new Random();
            int activationCode = random.nextInt(100000);
            System.out.println(activationCode);
            String activationText="激活码："+activationCode;
            //发邮件
            mailService.sendActivationMail(userCode,activationText);
            map.put("msg","success");
            session.setAttribute("activationCode",activationCode);
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","邮件发送失败！");
        }
        return map;
    }

    /**
     * 请求激活页面
     * @return
     */
    @RequestMapping("/active")
    public String active(){
        return "active";
    }

    /**
     * 激活
     * @return
     */
    @RequestMapping("/doActive")
    @ResponseBody
    public Object doActive(@RequestParam("activationCode") String activationCode,
                           HttpSession session){
        String activationCodeBefore = ((int)session.getAttribute("activationCode"))+"";
        Map map=new HashMap();
        if (activationCode.equals(activationCodeBefore)){
            User user =(User) session.getAttribute("user");
             userService.add(user);
            map.put("msg","success");
        }else {
            map.put("msg","激活错误！请重新输入");
        }
        return map;
    }
}
