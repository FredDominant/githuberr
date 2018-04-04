package com.example.andeladeveloper.githuberr.view;

import android.app.Activity;
import android.os.Bundle;

import com.example.andeladeveloper.githuberr.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private Activity mainActivity;

    @Test
    public void mainActivityShouldExist() {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .visible()
                .get();
        assertThat(mainActivity).isNotNull();
    }

    @Test
    public void mainActivityShouldHaveCorrectDetails() {
    mainActivity = Robolectric.setupActivity(MainActivity.class);
    assertThat(mainActivity.getTitle()).isNotNull();
    assertThat(mainActivity.getTitle()).isEqualTo(mainActivity.getString(R.string.app_name));
    }

    @Test
    public void mainActivityShouldBeCreated() {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
        mainActivity = controller.get();
        controller.create(new Bundle());
        assertThat(mainActivity).isNotNull();
        assertThat(mainActivity.isDestroyed()).isFalse();
    }
}
