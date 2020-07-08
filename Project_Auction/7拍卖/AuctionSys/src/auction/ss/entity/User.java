package auction.ss.entity;

/**
 * @author WM
 * @date 2020/7/8 4:02 下午
 * 描述信息：
 */
public class User {
    private Integer id;
    private String loginName;
    private String password;
    private String IdNum;
    private String tel;
    private String address;
    private Integer postNum ;

    public User() {
    }

    public User(Integer id, String loginName, String password, String idNum, String tel, String address,Integer postNum) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        IdNum = idNum;
        this.tel = tel;
        this.address = address;
        this.postNum=postNum;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNum() {
        return IdNum;
    }

    public void setIdNum(String idNum) {
        IdNum = idNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }
}
