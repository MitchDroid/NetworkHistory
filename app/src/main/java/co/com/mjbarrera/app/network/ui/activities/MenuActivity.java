package co.com.mjbarrera.app.network.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import java.io.IOException;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;
import co.com.mjbarrera.app.network.ui.fragments.FirstWirelesFragment;
import co.com.mjbarrera.app.network.ui.fragments.HomeFragment;
import co.com.mjbarrera.app.network.ui.fragments.InhalambricaFragment;
import co.com.mjbarrera.app.network.ui.fragments.InternetFragment;
import co.com.mjbarrera.app.network.ui.fragments.ModemFragment;
import co.com.mjbarrera.app.network.ui.fragments.RadioFragment;
import co.com.mjbarrera.app.network.ui.fragments.TelegraphFragment;
import co.com.mjbarrera.app.network.ui.fragments.TelephoneFragment;
import co.com.mjbarrera.app.network.utils.IntentHelper;

public class MenuActivity extends ActionBarActivity implements
        View.OnClickListener {

    private static Context mContext = PepfullApplication
            .getInstance().getApplicationContext();

    private Toolbar toolbar;
    private String PATH;
    public static String PDF_NAME = "docentes.pdf";
    private String mOutputFile;

    public static String CONST_DOWNLOAD = "/download/";
    private ResideMenu resideMenu;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemTelegraph;
    private ResideMenuItem itemTelehpone;
    private ResideMenuItem itemRadio;
    private ResideMenuItem itemWireless;
    private ResideMenuItem itemModem;
    private ResideMenuItem itemInternet;
    private ResideMenuItem itemFWireless;


    private android.support.v7.widget.ShareActionProvider mShareActionProvider;

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {

        }

        @Override
        public void closeMenu() {

        }
    };

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_material_menu_action_grey600_36dp);
        }
        PATH = Environment.getExternalStorageDirectory() + CONST_DOWNLOAD;
        mOutputFile = getPDFName();
        setUpMenu();
        if (savedInstanceState == null)
            changeFragment(new HomeFragment());
    }

    private void setUpMenu() {

        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome = new ResideMenuItem(this, R.drawable.ic_material_home_36dp,
                "Home");
        itemTelegraph = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "15 Enero,1837");
        itemTelehpone = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "16 Enero,1876");
        itemRadio = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "17th Enero,1888");
        itemWireless = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "17th Enero,1889");
        itemModem = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "16th Enero,1962");
        itemInternet = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "16th Enero,1969");
        itemFWireless = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "17th Jan,1971");


        itemHome.setOnClickListener(this);
        itemTelegraph.setOnClickListener(this);
        itemTelehpone.setOnClickListener(this);
        itemRadio.setOnClickListener(this);
        itemWireless.setOnClickListener(this);
        itemModem.setOnClickListener(this);
        itemInternet.setOnClickListener(this);
        itemFWireless.setOnClickListener(this);


        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemTelegraph, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemTelehpone, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemRadio, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemWireless, ResideMenu.DIRECTION_LEFT);

        resideMenu.addMenuItem(itemModem, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemInternet, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFWireless, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        if (view == itemHome) {
            changeFragment(new HomeFragment());
        } else if (view == itemTelegraph) {
            changeFragment(new TelegraphFragment());
        } else if (view == itemTelehpone) {
            changeFragment(new TelephoneFragment());
        } else if (view == itemRadio) {
            changeFragment(new RadioFragment());
        }else if (view == itemWireless) {
            changeFragment(new InhalambricaFragment());
        }else if (view == itemModem) {
            changeFragment(new ModemFragment());
        } else if (view == itemInternet) {
            changeFragment(new InternetFragment());
        } else if (view == itemFWireless) {
            changeFragment(new FirstWirelesFragment());
        }
        resideMenu.closeMenu();
    }

    private void changeFragment(Fragment targetFragment) {
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.global, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
                return true;
            case R.id.action_about:
                changeFragment(new AcercadeFragment());
                return true;
            case R.id.action_share:
                onShareAction();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void onShareAction(){

        Intent shareIntent = IntentHelper.shareIntent();
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.share_with)));
        // Set the share Intent
        setShareIntent(shareIntent);
    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    public ResideMenu getResideMenu() {
        return resideMenu;
    }

    private String getPDFName() {

        return PDF_NAME;
    }

}
