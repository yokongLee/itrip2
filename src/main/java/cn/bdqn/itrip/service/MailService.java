package cn.bdqn.itrip.service;

/**
 * 邮件业务类
 */
public interface MailService {
    /**
     * 发送注册激活邮件
     * @param mailTo
     * @param activationCode
     */
    void sendActivationMail(String mailTo,String activationCode);
}
