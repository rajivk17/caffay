package com.koraq.web;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class KoraqHandler {

	public KoraqHandler() {
		
	}
	
	public Mono<ServerResponse> stream(ServerRequest request) {
		Flux<String> names = Flux.just("KORAQ", "GREEN", "WIKI");
		
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(names.delayElements(Duration.ofSeconds(1)), String.class);
	}
}
