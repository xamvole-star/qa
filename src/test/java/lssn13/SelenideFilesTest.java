package lssn13;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
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

public class SelenideFilesTest {
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


    @ParameterizedTest(name = "Загрузка картинок на сайт: {0}")
    @ValueSource(strings = {"src\\test\\resources\\pic\\photo_202623.jpg",
            "src\\test\\resources\\pic\\photo_202623.jpg",
            "src\\test\\resources\\pic\\photo_03112026.png"} )
    void FileUpload(String UrlLoadFile) {
//        open("https://demoqa.com/automation-practice-form");
        open("https://blueimp.github.io/jQuery-File-Upload");
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        //<input label="Select picture" lang="en" id="uploadPicture" class="form-control" type="file"> css Selector
        $("input[type='file']").uploadFile(new File(UrlLoadFile));
    }
}

