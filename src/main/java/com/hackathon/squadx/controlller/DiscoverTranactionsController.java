package com.hackathon.squadx.controlller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import com.hackathon.squadx.model.TransactionAnalysis;
import com.hackathon.squadx.services.CustomerTransactions;
import com.hackathon.squadx.util.Executors;

@RestController
@RequestMapping({"/api"})
public class DiscoverTranactionsController {
	
	private final CustomerTransactions customerTransactions;
	
	public DiscoverTranactionsController(CustomerTransactions customerTransactions) {
		this.customerTransactions=customerTransactions;
	}
	
	@PostMapping(value="/discover-transactions")
	public DeferredResult<TransactionAnalysis> getData(HttpServletRequest request){
		return Executors.toDeferred(customerTransactions.discoverTransactions(request));
	}
	
	@GetMapping(value="/hello")
	public String getData(){
		return "Hello";
	}

}
