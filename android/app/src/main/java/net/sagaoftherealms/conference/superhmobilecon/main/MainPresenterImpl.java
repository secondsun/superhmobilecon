package net.sagaoftherealms.conference.superhmobilecon.main;

/**
 * Created by summers on 8/19/17.
 */

public class MainPresenterImpl implements MainContract.MainPresenter {

    private MainModel model = new MainModel();
    private final MainContract.MainView view;

    public MainPresenterImpl(MainContract.MainView view) {
        this.view = view;
    }

    @Override
    public void loadSignIn() {
    }
}
