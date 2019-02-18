package cn.bdqn.itrip.pojo;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {
    //用户id
    private Integer uId;
    //账号
    private String userCode;
    //密码
    private String userPassword;
    //用户类型
    private Integer userType;
    //用户名
    private String userName;
    //创建时间
    private Date creatDate;
    //修改时间
    private Date modifyDate;
    //创建者
    private Integer createBy;
    //修改者
    private Integer modifyBy;

    public User() {
    }

    public User(String userCode, String userPassword, String userName) {
        this.userCode = userCode;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public User(String userCode, String userPassword, Integer userType, String userName, Date creatDate, Integer createBy) {
        this.userCode = userCode;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userName = userName;
        this.creatDate = creatDate;
        this.createBy = createBy;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }
}
