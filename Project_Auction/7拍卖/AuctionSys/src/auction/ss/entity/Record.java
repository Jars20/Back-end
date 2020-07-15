package auction.ss.entity;

/**
 * @author WM
 * @date 2020/7/12 10:03 下午
 * 描述信息：
 */
public class Record {
    private Integer id;
    private Integer userId;
    private Integer productId;
    Double price;
    String time;

    public Record(Integer id, Integer userId, Integer productId, Double price, String time) {
        this.id = id;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
