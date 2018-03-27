package com.example.andeladeveloper.githuberr.view;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.andeladeveloper.githuberr.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = activityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View recyclerView = mainActivity.findViewById(R.id.recyclerView);
        assertNotNull(recyclerView);
    }

    @Test
    public void constraintLayoutIsDisplayedInMainActivity() {
        assertNotNull(mainActivity.findViewById(R.id.constraintLayout_main));
    }


    @Test
    public void lprogressBarIsDisplayedInMainActivity() {
        assertNotNull(mainActivity.findViewById(R.id.loader));

    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }

}
