import club.banyuan.OrderSender;
import club.banyuan.ProductSender;
import club.banyuan.SpringbootServerApplication;
import club.banyuan.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 消息队列测试类
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringbootServerApplication.class)
public class QueueTest {

	@Autowired
	private UserSender usersender;
	
	@Autowired
	private ProductSender productsender;
	
	@Autowired
	private OrderSender ordersender;
	
	/*
	 * 测试消息队列
	 */
	@Test
	public void test1(){
		this.usersender.send("UserSender.....");
		this.productsender.send("ProductSender....");
		this.ordersender.send("OrderSender......");
	}
}
