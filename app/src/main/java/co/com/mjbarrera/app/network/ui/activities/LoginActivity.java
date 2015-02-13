package co.com.mjbarrera.app.network.ui.activities;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.ui.fragments.LoginFragment;

public class LoginActivity extends ActionBarActivity implements LoginFragment.OnClickHomeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment()).commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onClick() {
        finish();
    }
}
