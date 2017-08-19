package net.sagaoftherealms.conference.superhmobilecon.main;

/**
 * Created by summers on 8/19/17.
 */

public class MainModel {

    public MainModel() {}

    public MainModel(boolean signedIn) {
        this.signedIn = signedIn;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    private boolean signedIn = false;
}
