package fr.android.androidexercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock LoginActivity activity;
    @InjectMocks LoginPresenter loginPresenter;

    @Test
    public void password_should_be_valid() throws Exception {
        loginPresenter.checkCredentials("password");
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void password_is_not_valid_is_empty() throws Exception {
        loginPresenter.checkCredentials("");
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void password_is_not_valid_is_shorter_than_3() throws Exception {
        loginPresenter.checkCredentials("ab");
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

    @Test
    public void password_should_be_valid_with_3() throws Exception {
        loginPresenter.checkCredentials("pas");
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void password_should_be_invalid_with_null() throws Exception {
        loginPresenter.checkCredentials(null);
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

}