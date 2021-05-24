package Spring.zyj.ss.beans;

/**
 * @ClassName Person
 * @Auther: YaJun
 * @Date: 2021 - 04 - 18 - 11:17
 * @Description: Spring.zyj.ss.beans
 * @version: 1.0
 */
public class Person {

    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("My name is :" + name);
    }
}
