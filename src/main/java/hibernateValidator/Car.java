package hibernateValidator;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class Car {
    @Range(min = 1, max = 2, message = "颜色只能为1或2")
    private int color;
    private double length;
    private double width;
    @NotBlank(message = "车辆名称不能为空")
    private String name;

    public Car(int color, double length, double width, String name) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.name = name;
    }


}
