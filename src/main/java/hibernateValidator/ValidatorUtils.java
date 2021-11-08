package hibernateValidator;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidatorUtils {
    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure()
            // 快速失败（即：第一个参数校验失败就返回错误信息，而不是校验所有的参数，并一次性返回所有的错误信息）
            .failFast(true)
            .buildValidatorFactory()
            .getValidator();

    public static void main(String[] args) {
        Car car = new Car(3, 12.3, 5.2, "name");
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        if (violations.size() > 0) {
            for(ConstraintViolation<Car> violation : violations) {
                System.out.println("校验失败的提示：" + violation.getMessage());
                System.out.println("校验不通过的属性名称：" + violation.getPropertyPath().toString());
            }
        }
    }
}
