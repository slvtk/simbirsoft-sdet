package helpers;

import config.Configurations;
import manager.ApplicationManager;
import pages.MailSenderPage;

public class MailSenderHelper extends HelperBase {

    MailSenderPage mailSenderPage;

    public MailSenderHelper(ApplicationManager applicationManager,
                            MailSenderPage mailSenderPage) {
        super(applicationManager);
        this.mailSenderPage = mailSenderPage;

    }

    public void sendEmail(String text) {
        try {
            mailSenderPage.newEmailForm()
                    .fillRecipientField(Configurations.EMAIL)
                    .fillSubjectField(Configurations.SUBJECT)
                    .fillTextField(text)
                    .sendEmail();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
