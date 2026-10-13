package lssn5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NewTestForTesting {

    @Test
    void autotest1() {
        Configuration.browserSize="1920x1200";
        Configuration.holdBrowserOpen=true;
        open("https://github.com");

    }
}