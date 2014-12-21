package uk.co.caeldev.spring.mvc;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder<T extends ResourceSupport> {

    private HttpStatus statusCode;
    private T resource;
    private HttpHeaders headers = new HttpHeaders();

    ResponseEntityBuilder() {
    }

    public static <V extends ResourceSupport> ResponseEntityBuilder<V> responseEntityBuilder() {
        return new ResponseEntityBuilder<>();
    }

    public ResponseEntityBuilder<T> statusCode(final HttpStatus statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseEntityBuilder<T> entity(final T resource) {
        this.resource = resource;
        return this;
    }

    public ResponseEntityBuilder<T> header(final String key, final String value) {
        headers.add(key, value);
        return this;
    }

    public ResponseEntity<T> build() {
        return new ResponseEntity<>(resource, headers, statusCode);
    }
}
