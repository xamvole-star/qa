package lssn13;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFilesTest  {
    @Test
    void FilesTest() throws Exception {
        open("https://github.com/junit-team/junit-framework/blob/main/README.md");
        File downloadedFile = $("[data-testid='raw-button']").download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of JUnit Platform, Jupiter, and Vintage.");
        }
    }
}

