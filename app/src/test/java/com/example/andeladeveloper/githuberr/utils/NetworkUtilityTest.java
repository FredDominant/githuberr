package com.example.andeladeveloper.githuberr.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowConnectivityManager;
import org.robolectric.shadows.ShadowNetworkInfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class NetworkUtilityTest {
    private ConnectivityManager connectivityManager;
    private ShadowNetworkInfo shadowOfActiveNetworkInfo;
    private ShadowConnectivityManager shadowConnectivityManager;

    @Before
    public void setUp() throws Exception {
        connectivityManager = (ConnectivityManager)
                RuntimeEnvironment.application.getSystemService(Context.CONNECTIVITY_SERVICE);
        shadowConnectivityManager = shadowOf(connectivityManager);
        shadowOfActiveNetworkInfo = shadowOf(connectivityManager.getActiveNetworkInfo());
    }

    @Test
    public void getActiveNetworkInfoShouldBeInitialized() {
        assertThat(connectivityManager.getActiveNetworkInfo()).isNotNull();
    }

    @Test
    public void isConnectedShouldReturnFalseIfNetworkInfoIsFalse() {
        shadowOfActiveNetworkInfo.setConnectionStatus(NetworkInfo.State.DISCONNECTED);
        NetworkUtility networkUtility =
                new NetworkUtility(RuntimeEnvironment.application.getApplicationContext());
        assertThat(networkUtility.isConnected()).isFalse();
    }

    @Test
    public void isConnectedShouldReturnTrueIfNetworkIsConnected() {
        shadowOfActiveNetworkInfo.setConnectionStatus(NetworkInfo.State.CONNECTED);
        NetworkUtility networkUtility =
                new NetworkUtility(RuntimeEnvironment.application.getApplicationContext());
        assertThat(networkUtility.isConnected()).isTrue();
    }

    @Test
    public void isConnectedShouldReturnFalseIfContextIsNull() {
       shadowConnectivityManager.setDefaultNetworkActive(false);
        NetworkUtility networkUtility =
                new NetworkUtility(null);
       assertThat(networkUtility.isConnected()).isFalse();
    }

    @After
    public void tearDown() throws Exception {
        shadowConnectivityManager = null;
        shadowOfActiveNetworkInfo = null;
    }

}
