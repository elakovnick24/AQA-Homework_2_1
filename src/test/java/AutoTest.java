import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:7777");
        $("[data-test-id=name] input").setValue("Василий");
        $("[data-test-id=phone] input").setValue("+79778889999");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void validationCheckName() {
        open("http://localhost:7777");
        $("[data-test-id=name] input").setValue("Marusya");
        $("[data-test-id=phone] input").setValue("+79778889999");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void validationCheckPhone() {
        open("http://localhost:7777");
        $("[data-test-id=name] input").setValue("Никита Несборочный");
        $("[data-test-id=phone] input").setValue("+797788899990000");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
}




