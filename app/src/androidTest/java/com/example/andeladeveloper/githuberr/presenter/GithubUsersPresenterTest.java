package com.example.andeladeveloper.githuberr.presenter;

import androidx.test.rule.ActivityTestRule;

import com.example.andeladeveloper.githuberr.service.GithubService;
import com.example.andeladeveloper.githuberr.all_users.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class GithubUsersPresenterTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity = null;
    private GithubUsersPresenter githubUsersPresenter;
    GithubService githubService = mock(GithubService.class);

    @Before
    public void setUp() throws Exception {
        mainActivity = activityTestRule.getActivity();
        githubUsersPresenter = new GithubUsersPresenter(mainActivity);
    }

//    @Test
//    public void getGithubersShouldWorkCorrectly() { // still failing
////        when(githubService.getApi).thenReturn()
//        githubUsersPresenter.getGithubers();
//        assertNotNull(mainActivity.users);
//    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
        githubUsersPresenter = null;
    }

}
