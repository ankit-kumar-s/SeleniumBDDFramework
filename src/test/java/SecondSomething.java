import org.testng.annotations.Test;
public class SecondSomething  {

    @Test
    public void secondSomething () {
        System.out.println("Environment: " + System.getProperty("environment")); //cmd to run in terminal to activate our profile .\mvnw.cmd test -Pqa
        System.out.println("My second TestNG test");
    }
}
