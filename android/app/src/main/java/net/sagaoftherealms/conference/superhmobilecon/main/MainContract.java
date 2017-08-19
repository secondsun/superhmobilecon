package net.sagaoftherealms.conference.superhmobilecon.main;

/**
 * Created by summers on 8/19/17.
 */

public class MainContract {

    public interface MainPresenter {
        void loadSignIn();
    }

    public interface MainView {
        void onSignInEvent(MainModel model);
    }

}
