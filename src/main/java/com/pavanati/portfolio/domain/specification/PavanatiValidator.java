package com.pavanati.portfolio.domain.specification;


import org.springframework.context.ApplicationContext;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.groups.Default;
import java.util.*;

public class PavanatiValidator {

    private final jakarta.validation.Validator beanValidator;

    private final ApplicationContext applicationContext;

    public PavanatiValidator(jakarta.validation.Validator beanValidator, ApplicationContext applicationContext) {
        Objects.requireNonNull(beanValidator);
        Objects.requireNonNull(applicationContext);

        this.applicationContext = applicationContext;
        this.beanValidator = beanValidator;
    }

    /**
     * Procede com a validação do Bean Validator utilizando os grupos sobre o bean informado, porém
     * ao invés de retornar os detalhes da validação uma exception será lançada.
     *
     * @param bean   Bean a ser validado.
     * @param groups Grupos que serão validados
     * @return Retorna o próprio bean validado, promovendo uma API mais fluente.
     * @throws ConstraintViolationException
     */
    public <T> T validate(final T bean, final Class<?>... groups) {
        final Set<ConstraintViolation<T>> violations = beanValidator.validate(bean, groups);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new LinkedHashSet<ConstraintViolation<?>>(
                    violations));
        }

        return bean;
    }

    /**
     * Procede com a validação do Bean Validator utilizando o grupo {@link Default} sobre o bean
     * informado, porém ao invés de retornar os detalhes da validação uma exception será lançada.
     *
     * @param bean Bean a ser validado.
     * @return Retorna o próprio bean validado, promovendo uma API mais fluente.
     * @throws ConstraintViolationException
     */
    public <T> T validate(final T bean) {
        validate(bean, Default.class);
        return bean;
    }


    /**
     * Procede com a validação da Specification sobre o bean informado, porém ao invés de retornar
     * os detalhes da validação uma exception será lançada.
     *
     * @param bean          Bean a ser validado.
     * @param specification Specification que será validada
     * @return Retorna o próprio bean validado, promovendo uma API mais fluente.
     * @throws ValidationException
     */
    public <T> T validate(final T bean, final ISpecification specification) {
        return validate(bean, Collections.singletonList(specification), Collections.emptyList());
    }

    /**
     * Procede com a validação da Specification sobre o bean informado, porém ao invés de retornar
     * os detalhes da validação uma exception será lançada.
     *
     * @param bean           Bean a ser validado.
     * @param specifications Specifications que serão validadas
     * @return Retorna o próprio bean validado, promovendo uma API mais fluente.
     * @throws ValidationException
     */
    public <T> T validate(final T bean, final List<ISpecification> specifications) {
        return validate(bean, specifications, Collections.emptyList());
    }

    /**
     * Procede com a validação da Specification sobre o bean informado, porém ao invés de retornar
     * os detalhes da validação uma exception será lançada.
     *
     * @param bean           Bean a ser validado.
     * @param specifications Specifications que serão validadas
     * @return Retorna o próprio bean validado, promovendo uma API mais fluente.
     * @throws ValidationException
     */
    public <T> T validate(final T bean, final ISpecification... specifications) {
        return validate(bean, Arrays.asList(specifications), Collections.emptyList());
    }

    /**
     * Procede com a validação da Specification sobre o bean informado, porém ao invés de retornar
     * os detalhes da validação uma exception será lançada.
     *
     * @param bean           Bean a ser validado.
     * @param specifications Specifications que serão validadas
     * @return Retorna o próprio bean validado, promovendo uma API mais fluente.
     * @throws ValidationException
     */
    public <T> T validate(final T bean, final List<ISpecification> specifications,
                          List<Class<? extends ISpecification>> specificationClasses) {
        SpecificationValidator.create(applicationContext)
                .addSpecifications(specifications)
                .addSpecificationClasses(specificationClasses)
                .validateWithException(bean);
        return bean;
    }

}
