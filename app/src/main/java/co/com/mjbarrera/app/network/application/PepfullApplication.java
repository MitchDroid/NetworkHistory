package co.com.mjbarrera.app.network.application;

import android.app.Application;

import java.util.List;

import butterknife.ButterKnife;
import co.com.mjbarrera.app.network.BuildConfig;
import co.com.mjbarrera.app.network.domain.Modem.Modem;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.FirstWireless;
import co.com.mjbarrera.app.network.domain.Internet.Internet;
import co.com.mjbarrera.app.network.domain.Wireless.Wireless;
import co.com.mjbarrera.app.network.domain.radio.Radio;
import co.com.mjbarrera.app.network.domain.telegraph.Telegraph;
import co.com.mjbarrera.app.network.domain.telephone.Telephone;
import co.com.mjbarrera.app.network.utils.JSONHandler;

public class PepfullApplication extends Application {

    private static PepfullApplication pepApplicationInstance;

    private static List<FirstWireless> listFirstWireless;
    private static List<Telegraph> listTelegraph;
    private static List<Telephone> listTelephone;
    private static List<Radio> listRadio;
    private static List<Wireless> listWireless;
    private static List<Modem> listModem;
    private static List<Internet> listInternet;

    private static boolean isSubContent = false;

    public static PepfullApplication getInstance() {

        return pepApplicationInstance;
    }

    public static List<FirstWireless> getListFirstWireless() {
        return listFirstWireless;
    }

    public static void setListFirstWireless(List<FirstWireless> listFirstWireless) {
        PepfullApplication.listFirstWireless = listFirstWireless;
    }

    public static List<Telegraph> getListTelegraph() {
        return listTelegraph;
    }

    public static void setListTelegraph(List<Telegraph> listTelegraph) {
        PepfullApplication.listTelegraph = listTelegraph;
    }

    public static List<Telephone> getListTelephone() {
        return listTelephone;
    }

    public static void setListTelephone(List<Telephone> listTelephone) {
        PepfullApplication.listTelephone = listTelephone;
    }

    public static List<Radio> getListRadio() {
        return listRadio;
    }

    public static void setListRadio(List<Radio> radio) {
        PepfullApplication.listRadio = radio;
    }

    public static List<Wireless> getListWireless() {
        return listWireless;
    }

    public static void setListWireless(List<Wireless> listWireless) {
        PepfullApplication.listWireless = listWireless;
    }

    public static List<Modem> getListModem() {
        return listModem;
    }

    public static void setListModem(List<Modem> modem) {
        PepfullApplication.listModem = modem;
    }

    public static List<Internet> getListInternet() {
        return listInternet;
    }

    public static void setListInternet(List<Internet> internet) {
        PepfullApplication.listInternet = internet;
    }

    public static boolean isIsSubContent() {
        return isSubContent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        pepApplicationInstance = this;

        initControllers();
    }

    private void initControllers() {
        JSONHandler.getTelegraphFromJSON();
        JSONHandler.getTelephoneFromJSON();
        JSONHandler.getRadioFromJSON();
        JSONHandler.getWirelessFromJSON();
        JSONHandler.getModemFromJSON();
        JSONHandler.getInternetFromJSON();
        JSONHandler.getFirstWirelessFromJSON();


    }
}
