package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "ticket", url = "http://192.168.22.92")
public interface TicketService {
	@RequestMapping(value = "/ticket/inner/tickettocontext", method = RequestMethod.POST)
	@ResponseBody
	Object getContext(@RequestParam("appid") String appId, @RequestParam("ticket") String ticket);
}
