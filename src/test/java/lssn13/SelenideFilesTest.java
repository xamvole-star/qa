import lssn12.BaseBrowserSetup;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFilesTest extends BaseBrowserSetup {
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
    //"/build/downloads/5eb3d53b-54d0-40a0-9733-5d10328c986a/README.md"

    @Disabled
    @ParameterizedTest(name = "Загрузка картинок на сайт: {0}")
    @ValueSource(strings = {"src\\test\\resources\\pic\\photo_1_03112026.png",
            "src\\test\\resources\\pic\\ptica_24921.jpg",
            "src\\test\\resources\\pic\\photo_03112026.png"})
    void FileUpload(String UrlLoadFile) {
        open("https://autotestsandbox.com/labs/preview-multiple-uploaded-files");
        //<input label="Select picture" lang="en" id="uploadPicture" class="form-control" type="file"> css Selector
        $("input[type='file']").uploadFile(new File(UrlLoadFile));
    }

    @Test
    void uploadMultipleFilesTest() {
        open("https://autotestsandbox.com/labs/preview-multiple-uploaded-files");
        File file1 = new File("src/test/resources/pic/photo_1_03112026.png");
        File file2 = new File("src/test/resources/pic/ptica_24921.jpg");
        File file3 = new File("src/test/resources/pic/photo_03112026.png");
        $("input[type='file']").uploadFile(file1, file2, file3);
    }
}

