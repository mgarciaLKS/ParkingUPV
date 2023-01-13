package com.lksnext.parking;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;

import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

/**
 * Helper class that retrieves the text value of a TextView.
 */
public class TextViewHelper {

    /**
     * Function that retrieves the text value of the TextView
     * @param matcher The ViewInteraction
     * @return String value of the TextView's text value
     */
    public static String getText(ViewInteraction matcher) {
        final String[] textHolder = new String[1];
        matcher.perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "Text of the view";
            }

            @Override
            public void perform(UiController uiController, View view) {
                textHolder[0] = ((TextView) view).getText().toString();
            }
        });
        return textHolder[0];
    }
}
