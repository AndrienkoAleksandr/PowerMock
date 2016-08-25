package PowerMock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created Alexander Andrienko
 */
public class ApplicationRegexTest {
    public static void main(String[] args) {
        ///license/(?!public)*
        Pattern pattern = Pattern.compile("/license/(?!public/).*");
        Matcher matcher = pattern.matcher("/license/properties");
        System.out.println(matcher.find());
    }
}
