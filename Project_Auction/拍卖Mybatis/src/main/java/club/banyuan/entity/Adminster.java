package club.banyuan.entity;

/**
 * @author WM
 * @date 2020/7/8 4:02 下午
 * 描述信息：
 */
public class Adminster {
    private Integer id;
    private String loginName;
    private String userName;
    private String password;

    public Adminster() {
    }

    public Adminster(Integer id, String loginName, String userName, String password) {
        this.id = id;
        this.loginName = loginName;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
