package com.mytaxi.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.*;

import com.mytaxi.android_demo.activities.MainActivity;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import org.junit.Rule;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());

        //Performing Login
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
        waitSeconds(1);

        //Searching for sa
        onView(withId(R.id.textSearch)).perform(typeText("sa"));
        waitSeconds(1);

        //Selecting second name
        onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
        waitSeconds(1);

        //Performing call
        onView(withId(R.id.fab)).perform(click());


    }

    private void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException ignored) {

        }
    }
}
