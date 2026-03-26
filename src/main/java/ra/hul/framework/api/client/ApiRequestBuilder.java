package ra.hul.framework.api.client;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ra.hul.framework.core.config.ConfigManager;

/**
 * Fluent builder for constructing complex API requests.
 * Use when you need more flexibility than ApiClient's convenience methods.
 */
public class ApiRequestBuilder {

    private final RequestSpecification spec;

    public ApiRequestBuilder() {
        this(ConfigManager.get("api.base.url"));
    }

    public ApiRequestBuilder(String baseUri) {
        spec = RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .filter(new AllureRestAssured());
    }

    public ApiRequestBuilder withHeader(String name, String value) {
        spec.header(name, value);
        return this;
    }

    public ApiRequestBuilder withQueryParam(String name, Object value) {
        spec.queryParam(name, value);
        return this;
    }

    public ApiRequestBuilder withBody(Object body) {
        spec.body(body);
        return this;
    }

    public ApiRequestBuilder withBasicAuth(String username, String password) {
        spec.auth().preemptive().basic(username, password);
        return this;
    }

    public ApiRequestBuilder withBearerToken(String token) {
        spec.header("Authorization", "Bearer " + token);
        return this;
    }

    public ApiRequestBuilder withContentType(ContentType contentType) {
        spec.contentType(contentType);
        return this;
    }

    public Response get(String endpoint) {
        return spec.get(endpoint).then().extract().response();
    }

    public Response post(String endpoint) {
        return spec.post(endpoint).then().extract().response();
    }

    public Response put(String endpoint) {
        return spec.put(endpoint).then().extract().response();
    }

    public Response patch(String endpoint) {
        return spec.patch(endpoint).then().extract().response();
    }

    public Response delete(String endpoint) {
        return spec.delete(endpoint).then().extract().response();
    }
}
