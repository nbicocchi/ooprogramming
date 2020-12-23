package org.nbicocchi.oop;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Test;

public class ShapeTest {
    @Test
    public void validateSettersAndGetters() {
        PojoClass pojo = PojoClassFactory.getPojoClass(Shape.class);
        Validator validator = ValidatorBuilder.create()
                // Lets make sure that we have a getter and a setter for every field defined.
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                // Lets also validate that they are behaving as expected
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        // Start the Test
        validator.validate(pojo);
    }

}