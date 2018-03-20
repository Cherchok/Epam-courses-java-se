package javase02.t07;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
public @interface BoatDescription {
    String name = "Titan";
    int model = 123878;
}
