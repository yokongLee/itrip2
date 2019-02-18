package cn.bdqn.itrip.service.impl;

import cn.bdqn.itrip.service.MailService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 邮件业务实现类
 */
@Service
public class MailServiceImpl implements MailService {
    @Resource
    private MailSender mailSender;
    /**
     * 发送注册激活邮件
     * @param mailTo
     * @param activationCode
     */
    @Override
    public void sendActivationMail(String mailTo, String activationCode) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("yokangLee@sina.com");
        //发送方式，接收者
        msg.setTo(mailTo);
        //标题
        msg.setSubject("爱旅行诚邀你的账号 !!!");
        //发送时间
        msg.setSentDate(new Date());
        //正文
        msg.setText(activationCode);
        //发送
        mailSender.send(msg);
        System.out.println("发送成功！");
    }
}
