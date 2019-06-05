package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SnsApiService;

@RestController
@RequestMapping("/attendance-admin/route")
public class RouteController implements ApplicationEventPublisherAware {
	@Autowired
	private SnsApiService SnsApiService;
	@Autowired
	private RouteDefinitionWriter routeDefinitionWriter;
	private ApplicationEventPublisher publisher;
	@GetMapping("/demo")
	public String update() {
		return "test";
	}
	@PostMapping("/demo")
	public String update(@RequestBody String gwdefinition) {
//		RouteDefinition definition = new RouteDefinition();
//		PredicateDefinition predicate = new PredicateDefinition();
//		Map<String, String> predicateParams = new HashMap<>(8);
//		definition.setId("baiduRoute");
//		predicate.setName("Path");
//		predicateParams.put("pattern", "/baidu");
//		predicateParams.put("pathPattern", "/baidu");
//		predicate.setArgs(predicateParams);
//		definition.setPredicates(Arrays.asList(predicate));
//		URI uri = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").build().toUri();
//		definition.setUri(uri);
//		routeDefinitionWriter.save(Mono.just(definition)).subscribe();
//		this.publisher.publishEvent(new RefreshRoutesEvent(this));
		return gwdefinition;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
}
