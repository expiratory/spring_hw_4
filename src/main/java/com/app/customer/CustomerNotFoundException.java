package com.app.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Requested customer does not exist"
)
public class CustomerNotFoundException
        extends RuntimeException {

    public CustomerNotFoundException(String t) {
        super(t);
    }
}
