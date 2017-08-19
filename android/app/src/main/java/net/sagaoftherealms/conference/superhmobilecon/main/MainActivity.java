package net.sagaoftherealms.conference.superhmobilecon.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.sagaoftherealms.conference.superhmobilecon.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView{

    private MainContract.MainPresenter presenter;

    private TextView signInTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.presenter = new MainPresenterImpl(this);
        signInTextView = findViewById(R.id.sign_in_message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadSignIn();
    }

    @Override
    public void onSignInEvent(MainModel model) {
        signInTextView.setText(model.isSignedIn()?R.string.main_signed_in:R.string.main_not_signed_in);
    }

    public void setPresenter(MainContract.MainPresenter presenter) {
        this.presenter = presenter;
    }
}
