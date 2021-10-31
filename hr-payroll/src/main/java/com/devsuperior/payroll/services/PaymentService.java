package com.devsuperior.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.payroll.entities.Payment;
import com.devsuperior.payroll.entities.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restemplate;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	
	public Payment getPayment(long workerId, int days) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", workerId+"");
		
		Worker worker = restemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
		
	}
	
}
