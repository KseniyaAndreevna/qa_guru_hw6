package guru.qa;

import org.junit.jupiter.api.Test;

import static guru.qa.IssueTestsConstants.*;

public class IssueAnnotatedStepsTest {

    @Test
    public void testIssueSearchAnnotatedSteps() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER, ISSUE_NAME);
    }
}
