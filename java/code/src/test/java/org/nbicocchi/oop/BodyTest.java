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
import static org.junit.Assert.*;

public class BodyTest {
    @Test
    public void validateSettersAndGetters() {
        PojoClass personPojo = PojoClassFactory.getPojoClass(Body.class);
        Validator validator = ValidatorBuilder.create()
                // Lets make sure that we have a getter and a setter for every field defined.
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                // Lets also validate that they are behaving as expected
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        // Start the Test
        validator.validate(personPojo);
    }

    @Test
    public void setSpeed() {
        Body b = new Body(0, 0 , 5, 5);
        b.setSpeed(7,7);
        assertEquals(7.0, b.getV_x(), 0.0);
    }

    @Test
    public void progress() {
        Body b = new Body(0, 0 , 3, 2);
        b.progress(2);
        assertEquals(6.0, b.getX(), 0.0);
        assertEquals(4.0, b.getY(), 0.0);
    }
}