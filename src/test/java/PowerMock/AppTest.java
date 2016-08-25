package PowerMock;

import com.license4j.License;
import com.license4j.LicenseValidator;

import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;

@PrepareForTest(value = {IdGenerator.class, LicenseValidator.class, Files.class})
public class AppTest extends PowerMockTestCase {
    @Mock
    private Server server;
    @Mock
    private License license;

    @Test
    public void test() {
        System.out.println(server.getClass());
        mockStatic(IdGenerator.class);
        mockStatic(LicenseValidator.class);

        when(IdGenerator.generate()).thenReturn(2);
        when(LicenseValidator.validate(anyString(),
                                       anyString(),
                                       anyString(),
                                       isNull(String.class),
                                       isNull(String.class),
                                       isNull(Date.class),
                                       isNull(Date.class))).thenReturn(license);

        System.out.println(new App().method());

        // Optionally verify that the static method was actually called
        verifyStatic(times(1));
//        IdGenerator.generateNewId();
    }


    @Test
    public void test2() {
        System.out.println(server.getClass());
        mockStatic(IdGenerator.class);

        when(IdGenerator.generate(anyInt(), any(byte[].class))).thenReturn(2);


        System.out.println(IdGenerator.generate(2, new byte[]{}));

        // Optionally verify that the static method was actually called
        verifyStatic(times(1));
//        IdGenerator.generateNewId();
    }

    @Test
    public void test3() throws IOException {
        Path path = mock(Path.class);
        mockStatic(Files.class);

        when(Files.write(any(Path.class), any(byte[].class))).thenReturn(path);

        Path path1 = Files.write(path, new byte[]{});

        verifyStatic(times(1));

        assertEquals(path, path1);
    }


}
