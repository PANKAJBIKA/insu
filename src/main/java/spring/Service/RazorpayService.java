/*package spring.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.entity.RazorpayOrder;
import spring.repo.RazorpayOrderRepository;

import java.util.Date;

@Service
public class RazorpayService {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorpayKeySecret;
    @Autowired
    private RazorpayClient client;

    @Autowired
    private RazorpayOrderRepository razorpayOrderRepository;
    @PostConstruct
    public void init() throws RazorpayException {
        this.client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }

   public RazorpayService() throws RazorpayException {
        this.client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }

    public Order createOrder(double amount) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // amount in the smallest currency unit
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "order_rcptid_11");
        orderRequest.put("payment_capture", 1); // 1 for automatic capture, 0 for manual capture

        Order order = client.Orders.create(orderRequest);
        

        // Save order details in the database
        RazorpayOrder razorpayOrder = new RazorpayOrder();
        razorpayOrder.setOrderId(order.get("id"));
        razorpayOrder.setAmount(amount);
        razorpayOrder.setCurrency("INR");
        razorpayOrder.setReceipt("order_rcptid_11");
        razorpayOrder.setPaymentCapture(true);
        razorpayOrder.setCreatedDate(new Date());

        razorpayOrderRepository.save(razorpayOrder);

        return order;
    }
}*/
