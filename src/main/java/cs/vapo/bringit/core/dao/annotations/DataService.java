package cs.vapo.bringit.core.dao.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Service
@Transactional(propagation = Propagation.MANDATORY)
@Validated
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataService {

    @AliasFor(annotation = Service.class)
    String value() default "";

    @AliasFor(annotation = Transactional.class)
    String transactionManager() default "";
}
