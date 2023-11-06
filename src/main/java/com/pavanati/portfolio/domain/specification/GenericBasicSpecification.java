package com.pavanati.portfolio.domain.specification;

public abstract class GenericBasicSpecification<T> extends BasicSpecification<T> {

    public GenericBasicSpecification(String message) {
        this.setMessage(message);
    }
}
