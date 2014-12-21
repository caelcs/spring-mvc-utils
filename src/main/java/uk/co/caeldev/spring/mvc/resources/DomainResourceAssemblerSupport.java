package uk.co.caeldev.spring.mvc.resources;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public abstract class DomainResourceAssemblerSupport<T, D extends ResourceSupport> extends ResourceAssemblerSupport<T, D> {

    /**
     * Creates a new {@link org.springframework.hateoas.mvc.ResourceAssemblerSupport} using the given controller class and resource type.
     *
     * @param controllerClass must not be {@literal null}.
     * @param resourceType    must not be {@literal null}.
     */
    public DomainResourceAssemblerSupport(Class<?> controllerClass, Class<D> resourceType) {
        super(controllerClass, resourceType);
    }

    public abstract T toDomain(D resource, T domain);
}
