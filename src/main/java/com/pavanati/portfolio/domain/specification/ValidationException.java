package com.pavanati.portfolio.domain.specification;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationException extends jakarta.validation.ValidationException {

    private final Set<ValidationMessage> validationMessages;

    public ValidationException(Set<ValidationMessage> validationMessages) {
        super(validationMessages.stream().map(ValidationMessage::getMessage)
                .collect(Collectors.joining(", ")));
        this.validationMessages = validationMessages;
    }

    public Set<ValidationMessage> getValidationMessages() {
        return Collections.unmodifiableSet(validationMessages);
    }

}
