package tests;

import config.Configurations;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class EmailSendTest extends TestBase {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест аутентификации, вычисление количества писем, включающих в subject слова: 'Simbirsoft Тестовое задание',а также отправка письма с результатами")
    public void testLogInAndCountingMatchingEmailsThenSendingEmail() {
        step("Аутентификация");
        appManager.getLoginPage()
                .open()
                .fillUsernameField(Configurations.EMAIL)
                .fillPasswordField(Configurations.PASSWORD);

        step("Подсчёт сообщений по критерию");
        String matchingMessages = appManager.getInboxPage()
                .fillSearchField(Configurations.SEARCH_QUERY)
                .getMatchingMessages();

        step("Формирование и отправка количества подходящих писем");
        appManager.getMailSenderPage()
                .newEmailForm()
                .sendEmail(Configurations.EMAIL, Configurations.SUBJECT, matchingMessages);
    }
}
