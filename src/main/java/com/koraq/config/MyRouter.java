package com.koraq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.koraq.web.KoraqHandler;

@Configuration
public class MyRouter {

	public MyRouter() {
		
	}
	
	@Bean
	public RouterFunction<ServerResponse> routes(KoraqHandler koraq) {
		return RouterFunctions.route(RequestPredicates.GET("/stream"), koraq::stream);
	}
}
