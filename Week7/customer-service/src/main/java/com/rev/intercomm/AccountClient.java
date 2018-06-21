package com.rev.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rev.entities.Account;
/*
 * similar set up to what we've seen with SOAP services - modeling our consuming app with the same interface as our service
 * here we create a feign client interface to speak to our account service 
 * 
 * http://www.baeldung.com/intro-to-feign
 */
@FeignClient("account-service")
public interface AccountClient {

	@GetMapping("/customer/{id}")
	public List<Account> findByCustomerId(@PathVariable("id") int id);
}
