package com.rickjms.microservices.order;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	MySQLContainer<?> mySqlContainer() {
		return new MySQLContainer<>(DockerImageName.parse("mysql:8.0"))
				.withDatabaseName("order_service")
				.withUsername("root")
				.withPassword("mysql");
	}

}
