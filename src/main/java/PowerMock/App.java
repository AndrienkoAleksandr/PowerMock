package PowerMock;

import com.license4j.LicenseValidator;

/**
 * Hello world!
 */
public class App {
    public String method() {
        int id = IdGenerator.generate();
        LicenseValidator.validate("test", "test", "test", null, null, null, null);
        return "Hello world and power mock!!! We generated " + id;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.method());
    }
}
