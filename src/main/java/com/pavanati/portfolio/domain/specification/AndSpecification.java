package com.pavanati.portfolio.domain.specification;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndSpecification<T> extends BasicSpecification<T> {
    private ISpecification<T, BasicSpecification<T>> a;
    private ISpecification<T, BasicSpecification<T>> b;
    private boolean resultA;
    private boolean resultB;

    public AndSpecification(ISpecification<T, BasicSpecification<T>> a, ISpecification<T, BasicSpecification<T>> b) {
        this.a = a;
        this.b = b;
    }

    public String getBean() {
        if (super.getBean() != null) {
            return super.getBean();
        } else if (!this.resultA) {
            return this.a.getBean();
        } else {
            return !this.resultB ? this.b.getBean() : null;
        }
    }

    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        } else if (!this.resultA) {
            return this.a.getMessage();
        } else {
            return !this.resultB ? this.b.getMessage() : null;
        }
    }

    public String getProperty() {
        if (super.getProperty() != null) {
            return super.getProperty();
        } else if (!this.resultA) {
            return this.a.getProperty();
        } else {
            return !this.resultB ? this.b.getProperty() : null;
        }
    }

    public boolean isSatisfiedBy(T candidate) {
        this.resultA = this.a.isSatisfiedBy(candidate);
        this.resultB = this.b.isSatisfiedBy(candidate);
        return this.resultA && this.resultB;
    }

    public String toString() {
        return "(" + this.a + " && " + this.b + ")";
    }

    public static class Builder<T> {
        private final List<BasicSpecification<T>> specifications = new ArrayList();

        public Builder(BasicSpecification<T>... specifications) {
            this.specifications.addAll(Arrays.asList(specifications));
        }

        public Builder<T> and(BasicSpecification<T> specification) {
            this.specifications.add(specification);
            return this;
        }

        public BasicSpecification<T> build() {
            if (this.specifications.isEmpty()) {
                return new BasicSpecification<T>() {
                    public boolean isSatisfiedBy(T candidate) {
                        return true;
                    }
                };
            } else if (this.specifications.size() == 1) {
                return (BasicSpecification)this.specifications.get(0);
            } else {
                AndSpecification andSpecification = new AndSpecification((ISpecification)this.specifications.get(0), (ISpecification)this.specifications.get(1));

                for(int i = 2; i < this.specifications.size(); ++i) {
                    andSpecification = new AndSpecification(andSpecification, (ISpecification)this.specifications.get(i));
                }

                return andSpecification;
            }
        }
    }
}

