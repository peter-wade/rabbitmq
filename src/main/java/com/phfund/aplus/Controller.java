package com.phfund.aplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private Sender sender;
	
	@RequestMapping(value="/send")
	public String forsend() {
		sender.send();
		return "alredy send";
	}
	
	
	

}
