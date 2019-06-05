package com.example.demo.filter;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.example.demo.service.TicketService;

/**
 * 解析用户是否作弊
 * 
 * @author crab
 *
 */
@Component
public class CheatGatewayFilterFactory extends AbstractGatewayFilterFactory<CheatGatewayFilterFactory.Config> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TicketService TicketService;

	public CheatGatewayFilterFactory() {
		super(Config.class);
	}

	@Override
	public List<String> shortcutFieldOrder() {
		return Arrays.asList("enabled");
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			return chain.filter(exchange);
		};
	}

	public static class Config {
		// 控制是否开启
		private boolean enabled;

		public boolean isEnabled() {
			return enabled;
		}

		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
	}
}