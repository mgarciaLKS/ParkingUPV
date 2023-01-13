package com.lksnext.parking;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static com.lksnext.parking.TextViewHelper.getText;

import static org.hamcrest.core.AllOf.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.lksnext.parking.view.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test that checks if the apps navigation between fragments is correct
 */
@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    public static final String TEST_NAME = "Foo bar";

    //Set a rule to launch the activity before the test starts and close when the test finishes
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void navigationTest() {
        //Main Fragment
        //Check if the title view is displayed
        onView(allOf(withId(R.id.tv_title), withText(R.string.fragment_main))).check(matches(isDisplayed()));
        //Perform click on next button
        onView(withId(R.id.btn_next)).check(matches(isDisplayed())).perform(click());

        //Step 1
        //Check if the title view is displayed
        onView(allOf(withId(R.id.tv_title), withText(R.string.fragment_step1))).check(matches(isDisplayed()));
        //Type sample text in the EditText
        onView(withId(R.id.et_name)).perform(typeText(TEST_NAME), closeSoftKeyboard());
        //Perform click on next button
        onView(withId(R.id.btn_next)).check(matches(isDisplayed())).perform(click());

        //Step 2
        //Check if the title view is displayed
        onView(allOf(withId(R.id.tv_title), withText(R.string.fragment_step2))).check(matches(isDisplayed()));
        //Check if the name view has the correct value
        onView(withId(R.id.tv_name)).check(matches(withText(TEST_NAME)));
        //Perform click on roll button
        onView(withId(R.id.btn_roll)).check(matches(isDisplayed())).perform(click());
        //Get the rollValue text to use it as comparison latter
        String rollValue = getText(onView(withId(R.id.tv_rollValue)));
        //Perform click on next button
        onView(withId(R.id.btn_next)).check(matches(isDisplayed())).perform(click());

        //End
        //Check if the endValue is equal to the rollValue
        onView(allOf(withId(R.id.tv_endValue), withText(rollValue))).check(matches(isDisplayed()));
        //Perform click on finish button
        onView(withId(R.id.btn_finish)).check(matches(isDisplayed())).perform(click());

        //Main Fragment
        //Check if the title view is displayed
        onView(allOf(withId(R.id.tv_title), withText(R.string.fragment_main))).check(matches(isDisplayed()));
    }
}
