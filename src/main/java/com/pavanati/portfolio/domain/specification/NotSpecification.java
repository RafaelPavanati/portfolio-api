package com.pavanati.portfolio.domain.specification;


public class NotSpecification<T> extends BasicSpecification<T> {
    private ISpecification<T, BasicSpecification<T>> wrapped;
    private boolean result;

    public NotSpecification(ISpecification<T, BasicSpecification<T>> wrapped) {
        this.wrapped = wrapped;
    }

    public String getBean() {
        if (super.getBean() != null) {
            return super.getBean();
        } else {
            return !this.result ? this.wrapped.getBean() : null;
        }
    }

    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        } else {
            return !this.result ? this.wrapped.getMessage() : null;
        }
    }

    public String getProperty() {
        if (super.getProperty() != null) {
            return super.getProperty();
        } else {
            return !this.result ? this.wrapped.getProperty() : null;
        }
    }

    public boolean isSatisfiedBy(T candidate) {
        this.result = this.wrapped.isSatisfiedBy(candidate);
        return !this.result;
    }

    public String toString() {
        return "!" + this.wrapped;
    }
}
