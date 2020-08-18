import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutoTest {
    @Test
    void shouldSubmitRequest() {
        open("http://localhost:7777");
        SelenideElement form = $(".form[method=post]");
        form.$("[data-test-id=name] input").setValue("Василий Алибабаевич");
        form.$("[data-test-id=phone] input").setValue("+79778889999");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=button]").click();

        $("[data-test-id]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void validationCheckName() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Marusya");
        form.$("[data-test-id=phone] input").setValue("+79778889999");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=button]").click();

        $("[data-test-id]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void validationCheckPhone() {
        open("http://localhost:7777");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Marusya");
        form.$("[data-test-id=phone] input").setValue("+797788899990000");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=button]").click();

        $("[data-test-id]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}



