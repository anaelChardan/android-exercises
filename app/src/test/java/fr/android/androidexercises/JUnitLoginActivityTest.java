package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class JUnitLoginActivityTest {
    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void check_init() throws Exception {
        activity.notLogged();

        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();

    }

    @Test
    public void should_set_logged_state() throws Exception {
        activity.logged();

        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

}