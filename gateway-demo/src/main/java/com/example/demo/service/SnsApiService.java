package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "snsapi", url = "http://192.168.22.144")
public interface SnsApiService {

	
	@RequestMapping(value = "/snsapi/rest/inner/token/getToken", method = RequestMethod.GET)
	@ResponseBody
	Object getToken(@RequestParam("oauth_token")String oauthToken,@RequestParam("oauth_consumer_key")String oauthConsumerKey);
}
