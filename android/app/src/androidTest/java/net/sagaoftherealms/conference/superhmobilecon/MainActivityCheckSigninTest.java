package net.sagaoftherealms.conference.superhmobilecon;

import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import net.sagaoftherealms.conference.superhmobilecon.main.MainActivity;
import net.sagaoftherealms.conference.superhmobilecon.main.MainContract;
import net.sagaoftherealms.conference.superhmobilecon.main.MainModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * The Main activity should check that the user is signed in and display results as appropriate
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityCheckSigninTest {

    private StubPresenter stubPresenter = new StubPresenter();

    @Rule
    public ActivityTestRule<MainActivity> testRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private static final MainModel loggedInModel = new MainModel(true);
    private static final MainModel notLoggedInModel = new MainModel(false);

    @Before
    public void before() {
        testRule.getActivity().setPresenter(stubPresenter);
    }

    @Test
    @UiThreadTest
    /**
     * We are not signed in by default so it should display the not signed in text.
     */
    public void displaysSignInIfNotSignedIn() throws Exception {
        stubPresenter.model = notLoggedInModel;
        stubPresenter.loadSignIn();
        assertTrue(((TextView)testRule.getActivity().findViewById(R.id.sign_in_message)).getText().equals(testRule.getActivity().getString(R.string.main_not_signed_in)));
    }

    @Test
    @UiThreadTest
    /**
     * At some point we will be able to sign in, display sign in text.
     */
    public void displaysSignInIfSignedIn() throws Exception {
        stubPresenter.model = loggedInModel;
        stubPresenter.loadSignIn();
        assertTrue(((TextView)testRule.getActivity().findViewById(R.id.sign_in_message)).getText().equals(testRule.getActivity().getString(R.string.main_signed_in)));
    }

    private class StubPresenter implements MainContract.MainPresenter {

        MainModel model = new MainModel();

        @Override
        public void loadSignIn() {
            testRule.getActivity().onSignInEvent(model);
        }
    }

}
