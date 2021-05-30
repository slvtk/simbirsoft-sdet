package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

public class EmailSendTest extends TestBase {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест аутентификации, вычисление количества писем, включающих в subject слова: 'Simbirsoft Тестовое задание',а также отправка письма с результатами")
    public void testLogInAndCountingMatchingEmailsThenSendingEmail() {
        //navigate to gmail index page(with redirect to login)
        step("Переход на начальную страницу");
        app.getNavigationHelper().navigateToIndexPage();
        //logIn
        step("Аутентификация");
        app.getLoginHelper().login();
        //find matching messages
        step("Поиск сообщений по критерию");
        app.getInboxHelper().findMatchingMessages();
        //message send
        step("Формирование и отправка количества подходящих писем");
        app.getMailSenderHelper().sendEmail(app.getInboxHelper().getMatchingMessages());
    }
}
