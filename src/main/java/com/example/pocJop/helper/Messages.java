package com.example.pocJop.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Locale;

@Component
public final class Messages {

    @Autowired
    MessageSource messageSource;

    public String getMessage(String messageRef, String... args) {
        return String.format(messageSource.getMessage(messageRef, null, Locale.getDefault()), String.join(",", Arrays.asList(args)));
    }
}
