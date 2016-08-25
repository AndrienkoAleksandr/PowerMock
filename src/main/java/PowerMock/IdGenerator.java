package PowerMock;

import java.util.Random;

public class IdGenerator {
    public static synchronized int generate() {
        return new Random().nextInt() * 100 + 15;
    }

    public static synchronized int generate(int start, byte[] array) {
        return new Random().nextInt() * 100 + start;
    }
}
