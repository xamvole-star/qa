package lssn4;

import static com.codeborne.selenide.DragAndDropOptions.to;   //для перетаскивания
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.DragAndDropOptions.to;   //для перетаскивания

public class hw_lssn4 {
/*2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
 - Откройте https://the-internet.herokuapp.com/drag_and_drop
 - Перенесите прямоугольник А на место В
 - Проверьте, что прямоугольники действительно поменялись
 - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
*/

    @Test
    void DragAndDroping() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1028";

        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDrop(to("#column-b"));

    }
}