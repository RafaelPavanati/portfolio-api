package com.pavanati.portfolio.domain.specification;

/**
 * A interface <code>ISpecification</code> representa o modelo de especificações
 *
 * @param <T>
 * @param <E>
 */
public interface ISpecification<T, E extends ISpecification<T, E>> {

    /**
     * Valida de acordo com a condição implementada
     *
     * @param candidate objeto a ser validado
     * @return informação boleana referente a aprovação ou não da condição
     * testada
     */
    boolean isSatisfiedBy(T candidate);

    /**
     * Permiti unir duas especificações atráves da condição E
     * <p>
     * <p>
     * <blockquote>
     * <p>
     * <pre>
     * sp1.and(sp2).isSatisfiedBy(object)
     * </pre>
     * <p>
     * </blockquote>
     * <p>
     *
     * @param right outra especificação
     * @return especificações com o condicional
     */
    E and(E right);

    /**
     * Permiti unir duas especificações atráves da condição OR
     * <p>
     * <p>
     * <blockquote>
     * <p>
     * <pre>
     * sp1.or(sp2).isSatisfiedBy(object)
     * </pre>
     * <p>
     * </blockquote>
     * <p>
     *
     * @param right outra especificação
     * @return especificações com o condicional
     */
    E or(E right);

    /**
     * Permiti unir duas especificações atráves da condição NOT
     * <p>
     * <p>
     * <blockquote>
     * <p>
     * <pre>
     * sp1.not(sp2).isSatisfiedBy(object)
     * </pre>
     * <p>
     * </blockquote>
     * <p>
     *
     * @return especificações com o condicional
     */
    E not();

    /**
     * Retona o Java name do bean que se está validando
     *
     * @return Java name do bean que se está validando
     */
    String getBean();

    /**
     * Retona a mensagem de validação
     *
     * @return Mensagem de validação
     */
    String getMessage();

    /**
     * Retona o nome da propriedade do bean que se está validando
     *
     * @return Nome da propriedade do bean que se está validando
     */
    String getProperty();

    /**
     * Retona o Java name do bean que se está validando
     *
     * @param bean
     * @return Java name do bean que se está validando
     */
    E setBean(String bean);

    /**
     * Método que irá armazenar a mensagem de validação
     *
     * @param message Mensagem de validação caso a especificação falhe
     * @return
     */
    E setMessage(String message);

    /**
     * Método que irá armazenar a propriedade do bean que se está validando
     *
     * @param property Nome da propriedade do bean que se está validando
     * @return
     */
    E setProperty(String property);
}
