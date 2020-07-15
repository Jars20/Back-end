package club.banyuan.entity;

/**
 * @author WM
 * @date 2020/7/9 4:00 下午
 * 描述信息：
 */
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double lowPrice;
    private Double basePrice;
    private String startTime;
    private String finalTime;
    private int onSell;
    private int soldOrNot;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
    }

    public Product(Integer id, String name, String description, Double lowPrice, Double basePrice, String startTime, String finalTime, int onSell, int soldOrNot) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lowPrice = lowPrice;
        this.basePrice = basePrice;
        this.startTime = startTime;
        this.finalTime = finalTime;
        this.onSell = onSell;
        this.soldOrNot = soldOrNot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    public int getOnSell() {
        return onSell;
    }

    public void setOnSell(int onSell) {
        this.onSell = onSell;
    }

    public int getSoldOrNot() {
        return soldOrNot;
    }

    public void setSoldOrNot(int soldOrNot) {
        this.soldOrNot = soldOrNot;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lowPrice=" + lowPrice +
                ", basePrice=" + basePrice +
                ", startTime='" + startTime + '\'' +
                ", finalTime='" + finalTime + '\'' +
                ", onSell=" + onSell +
                ", soldOrNot=" + soldOrNot +
                '}';
    }
}
