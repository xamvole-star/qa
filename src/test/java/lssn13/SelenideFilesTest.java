package lssn13;

import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFilesTest {
    @Test
    void FilesTest() {
        open("https://github.com/junit-team/junit-framework/blob/main/README.md");
        File downloadedFile = $("[data-testid='raw-button']").download();
    }
}

