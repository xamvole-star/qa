package lssn13;

import com.codeborne.xlstest.XLS;
import lssn12.BaseBrowserSetup;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParsingTest extends BaseBrowserSetup {
    @Test
    void pdfParseTest() throws IOException {
        open("https://docs.junit.org/6.1.3/overview.html");
        File downloadPdf = $("a[href='_exports/junit-user-guide-6.1.3.pdf#overview']").download();
        PDF content = new PDF(downloadPdf);
        assertThat(content.title).contains("JUnit");

    }

    @Test
    void xlsxFileTest() {
        open("https://shkola7arsenev-r25.gosweb.gosuslugi.ru/svedeniya-ob-obrazovatelnoy-organizatsii/pedagogicheskiy-sostav");
        File downloadXlsx = $("a[href='/netcat_files/246/4645/Informatsiya_o_personal_nom_sostave_pedagogicheskih_rabotnikov_gimnazii_3_.xlsx']").download();
        XLS content = new XLS(downloadXlsx);
        assertThat(content.excel.getSheetAt(1).getRow(3).getCell(1).toString()).contains("Аникина Ирина  Валерьевна");
        var sheet = content.excel.getSheetAt(1);
        for (int i = 3; i <= sheet.getLastRowNum(); i++) {
        System.out.println(sheet.getRow(i).getCell(1).toString().trim());
        //индексация в excel начинается с 1, в java с 0
        }
    }
}



