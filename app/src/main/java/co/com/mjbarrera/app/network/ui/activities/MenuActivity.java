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
import co.com.mjbarrera.app.network.ui.fragments.HomeFragment;
import co.com.mjbarrera.app.network.ui.fragments.RadioFragment;
import co.com.mjbarrera.app.network.ui.fragments.TelegraphFragment;
import co.com.mjbarrera.app.network.ui.fragments.TelephoneFragment;
import co.com.mjbarrera.app.network.ui.fragments.PEgresoFragment;
import co.com.mjbarrera.app.network.ui.fragments.POcupacionalFragment;
import co.com.mjbarrera.app.network.ui.fragments.PProfesionalFragment;
import co.com.mjbarrera.app.network.ui.fragments.PProgramaFragment;
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
    private ResideMenuItem itemPPrograma;
    private ResideMenuItem itemPProfesional;
    private ResideMenuItem itemPOcupacional;

    private ResideMenuItem itemPEgreso;
    private ResideMenuItem itemDocentes;

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
                R.drawable.ic_material_obj_especifico_white_36dp, "17th Jan,1888");
        itemPPrograma = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "Perfil Programa");
        itemPProfesional = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "Perfil Profesional");
        itemPOcupacional = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "Perfil Ocupacional");
        itemPEgreso = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "Perfil Egreso");
        itemDocentes = new ResideMenuItem(this,
                R.drawable.ic_material_obj_especifico_white_36dp, "Docentes");

        itemHome.setOnClickListener(this);
        itemTelegraph.setOnClickListener(this);
        itemTelehpone.setOnClickListener(this);
        itemRadio.setOnClickListener(this);
        itemPPrograma.setOnClickListener(this);
        itemPProfesional.setOnClickListener(this);
        itemPOcupacional.setOnClickListener(this);
        itemPEgreso.setOnClickListener(this);
        itemDocentes.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemTelegraph, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemTelehpone, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemRadio, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPPrograma, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPProfesional, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPOcupacional, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPEgreso, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemDocentes, ResideMenu.DIRECTION_LEFT);

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
        } else if (view == itemHome) {
            changeFragment(new TelegraphFragment());
        } else if (view == itemTelegraph) {
            changeFragment(new TelephoneFragment());
        } else if (view == itemTelehpone) {
            changeFragment(new RadioFragment());
        } else if (view == itemRadio) {
            changeFragment(new PProgramaFragment());
        } else if (view == itemPProfesional) {
            changeFragment(new PProfesionalFragment());
        } else if (view == itemPOcupacional) {
            changeFragment(new POcupacionalFragment());
        } else if (view == itemPEgreso) {
            changeFragment(new PEgresoFragment());
        }else if(view == itemDocentes){
            try {
                IntentHelper.goToFile(PATH + mOutputFile);
            }catch (IOException io){
                io.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

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
