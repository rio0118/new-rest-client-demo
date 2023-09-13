package dev.rio0118.newrestclientdemo;

import dev.rio0118.newrestclientdemo.client.JsonPlaceHolderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class NewRestClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewRestClientDemoApplication.class, args);
	}

	@Bean
	JsonPlaceHolderService jsonPlaceHolderService() {
		RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(client))
				.build();
		return factory.createClient(JsonPlaceHolderService.class);
	}
}
