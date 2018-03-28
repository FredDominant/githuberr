package com.example.andeladeveloper.githuberr.presenter;

import android.support.test.rule.ActivityTestRule;

import com.example.andeladeveloper.githuberr.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;


/**
 * Created by andeladeveloper on 28/03/2018.
 */
public class GithubUsersPresenterTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity = null;
    private GithubUsersPresenter githubUsersPresenter;

    @Before
    public void setUp() throws Exception {
        mainActivity = activityTestRule.getActivity();
        githubUsersPresenter = new GithubUsersPresenter(mainActivity);
    }

    @Test
    public void getGithubersShouldWorkCorrectly() { // still failing
        githubUsersPresenter.getGithubers();
        assertNotNull(mainActivity.users);
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
        githubUsersPresenter = null;
    }

}
