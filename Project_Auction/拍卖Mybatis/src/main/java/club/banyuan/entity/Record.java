package club.banyuan.entity;

/**
 * @author WM
 * @date 2020/7/12 10:03 下午
 * 描述信息：
 */
public class Record {
    private Integer id;
    private String userName;
    private Integer productId;
    Double price;
    String time;


    public Record(Integer id, String userName, Integer productId, Double price, String time) {
        this.id = id;
        this.userName = userName;
        this.productId = productId;
        this.price = price;
        this.time = time;
    }

    public Record() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", productId=" + productId +
                ", price=" + price +
                ", time='" + time + '\'' +
                '}';
    }
}
