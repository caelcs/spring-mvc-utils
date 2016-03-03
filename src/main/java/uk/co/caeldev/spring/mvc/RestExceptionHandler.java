package uk.co.caeldev.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @ResponseBody
    public ErrorInfo notFound(final HttpServletRequest req) {
        String errorURL = req.getRequestURL().toString();

        return new ErrorInfo(errorURL, "Resource not found");
    }

    public class ErrorInfo {
        private final String errorURL;
        private final String message;

        public ErrorInfo(final String errorURL, final String message) {
            this.errorURL = errorURL;
            this.message = message;
        }

        public String getErrorURL() {
            return errorURL;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public int hashCode() {
            return Objects.hash(errorURL, message);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final ErrorInfo other = (ErrorInfo) obj;
            return Objects.equals(this.errorURL, other.errorURL) && Objects.equals(this.message, other.message);
        }
    }
}
