package net.sagaoftherealms.conference.superhmobilecon;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * The Main activity should check that the user is signed in and display results as appropriate
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityCheckSigninTest {

    @Rule
    public IntentsTestRule<MainActivity> testRule = new IntentsTestRule<MainActivity>(MainActivity.class);

    @Test
    public void displaysSignInIfNotSignedIn() throws Exception {
        onView(withId(R.id.sign_in_message)).check(matches(withText(R.string.main_not_signed_in)));
    }


    @Test
    public void displaysSignInIfSignedIn() throws Exception {
        onView(withId(R.id.sign_in_message)).check(matches(withText(R.string.main_signed_in)));
    }

}
