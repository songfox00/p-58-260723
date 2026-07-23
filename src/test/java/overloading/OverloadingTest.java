package overloading;

import org.junit.jupiter.api.Test;

public class OverloadingTest {
    @Test
    void t1() {
        Person p1 = new Person();
        p1.introduce();
        p1.introduce(10);
        p1.introduce("홍길동");
        p1.introduce(20);

        Person p2 = new Person();
        Person p3 = new Person(20, "홍길동");
    }
}
