package com.rishabh.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.eureka.services.StripeClient;
import com.stripe.model.Charge;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	 private StripeClient stripeClient;

	    @Autowired
	    PaymentController(StripeClient stripeClient) {
	        this.stripeClient = stripeClient;
	    }

	    @PostMapping("/charge/{token}/{price}")
	    public Charge chargeCard(@RequestParam("token")String token,@RequestParam("price")int price) throws Exception {
	        String paymentToken = token;
	        Double amount = Double.valueOf(price);
	        return this.stripeClient.chargeNewCard(paymentToken, amount);
	    }

}
