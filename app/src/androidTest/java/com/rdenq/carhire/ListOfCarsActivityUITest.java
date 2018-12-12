package com.rdenq.carhire;

import android.content.Context;
import android.content.pm.ActivityInfo;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.pressBack;
import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ListOfCarsActivityUITest {

    private ListOfCarsActivity mListOfCarsActivity;

    @Rule
    public ActivityTestRule<ListOfCarsActivity> mActivityRule =
            new ActivityTestRule<>(ListOfCarsActivity.class);

    @Test
    public void packageName() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.rdenq.carhire", appContext.getPackageName());
    }

    @Test
    public void legend() {
        onView(withId(R.id.pickup_location)).check(matches(withText("Las Vegas - Airport")));
        onView(withId(R.id.return_location)).check(matches(withText("Las Vegas - Airport")));
        onView(withId(R.id.pickup_time)).check(matches(withText("Mon Sep 22 10:00")));
        onView(withId(R.id.return_time)).check(matches(withText("Mon Oct 06 10:00")));
    }

    @Test
    public void all_view_visibility() {
        //legend
        onView(withId(R.id.legend)).check(matches(isDisplayed()));
        onView(withId(R.id.pickup_time)).check(matches(isDisplayed()));
        onView(withId(R.id.pickup_location)).check(matches(isDisplayed()));
        onView(withId(R.id.return_time)).check(matches(isDisplayed()));
        onView(withId(R.id.return_location)).check(matches(isDisplayed()));

        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withText("Kia Rio or similar"))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.make_model_name))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.num_of_passengers))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.num_of_bags))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.num_of_doors))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.fuel_type))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.photo))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.vendor_name))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.price))));
        onView(withId(R.id.vehicle_recycle_view)).check(matches(hasDescendant(withId(R.id.per_day))));

    }

    @Test
    public void screen_rotation() throws InterruptedException {

        mListOfCarsActivity = mActivityRule.getActivity();

        onView(withText("CarHire")).check(matches(isDisplayed()));
        onView(withId(R.id.legend)).check(matches(isDisplayed()));
        mListOfCarsActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Thread.sleep(1000);
        onView(withText("CarHire")).check(matches(isDisplayed()));
        onView(withId(R.id.legend)).check(matches(isDisplayed()));
        mListOfCarsActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Thread.sleep(1000);
        onView(withText("CarHire")).check(matches(isDisplayed()));
        onView(withId(R.id.legend)).check(matches(isDisplayed()));
        onView(withId(R.id.legend)).perform(click());
    }

    @Test
    public void car_details_screen() throws InterruptedException {

        onView(withText("Kia Rio or similar")).perform(click());
        Thread.sleep(500);
        onView(withText("Selected Car")).check(matches(isDisplayed()));

        onView(withId(R.id.make_model_name)).check(matches(isDisplayed()));
        onView(withId(R.id.num_of_passengers)).check(matches(isDisplayed()));
        onView(withId(R.id.num_of_bags)).check(matches(isDisplayed()));
        onView(withId(R.id.num_of_doors)).check(matches(isDisplayed()));
        onView(withId(R.id.fuel_type)).check(matches(isDisplayed()));
        onView(withId(R.id.photo)).check(matches(isDisplayed()));
        onView(withId(R.id.vendor_name)).check(matches(isDisplayed()));
        onView(withId(R.id.price)).check(matches(isDisplayed()));
        onView(withId(R.id.per_day)).check(matches(isDisplayed()));
        onView(withId(R.id.book_now_cardview)).check(matches(isDisplayed()));

        pressBack();
        Thread.sleep(100);
        onView(withText("CarHire")).check(matches(isDisplayed()));



    }
}