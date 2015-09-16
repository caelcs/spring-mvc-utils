package uk.co.caeldev.spring.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder<T> {

    private HttpStatus statusCode;
    private T resource;
    private HttpHeaders headers = new HttpHeaders();

    ResponseEntityBuilder() {
    }

    public static <T> ResponseEntityBuilder<T> responseEntityBuilder() {
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
