package helpers;

import config.Configurations;
import manager.ApplicationManager;
import pages.InboxPage;

public class InboxHelper extends HelperBase {

    private final InboxPage inboxPage;
    private String matchingMessages;

    public InboxHelper(ApplicationManager applicationManager, InboxPage inboxPage) {
        super(applicationManager);
        this.inboxPage = inboxPage;
    }

    public void findMatchingMessages() {
        matchingMessages = inboxPage
                .fillSearchField(Configurations.SEARCH_QUERY)
                .getMatchingMessages();
    }

    public String getMatchingMessages() {
        return matchingMessages;
    }
}
