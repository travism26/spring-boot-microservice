package com.rickjms.microservices.order.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryClientStub {

    public static void stubInventoryClient(String skuCode, int quantity, boolean inStock) {
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(inStock ? "true" : "false")));
    }
}
