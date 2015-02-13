package co.com.mjbarrera.app.network.application;

import android.app.Application;

import java.util.List;

import butterknife.ButterKnife;
import co.com.mjbarrera.app.network.BuildConfig;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.PEgreso;
import co.com.mjbarrera.app.network.domain.PerfilOcupacional.POcupacional;
import co.com.mjbarrera.app.network.domain.PerfilProfesional.PProfesional;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PPrograma;
import co.com.mjbarrera.app.network.domain.radio.Radio;
import co.com.mjbarrera.app.network.domain.telephone.Telephone;
import co.com.mjbarrera.app.network.domain.telegraph.Telegraph;
import co.com.mjbarrera.app.network.utils.JSONHandler;

public class PepfullApplication extends Application {

    private static PepfullApplication pepApplicationInstance;

    private static PEgreso perfilEgresoResponse;
    private static List<Telegraph> listTelegraph;
    private static List<Telephone> listTelephone;
    private static List<Radio> listRadio;
    private static PProfesional pProfesional;
    private static POcupacional pOcupacional;
    private static PPrograma pPrograma;
    private static boolean isSubContent = false;

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
        JSONHandler.getPerfilEgresoDataFromJSON();

        JSONHandler.getRadioFromJSON();
        JSONHandler.getPProfesionalFromJSON();
        JSONHandler.getPerfilOcupacionalDaraFromJSON();
        JSONHandler.getPProgramaFromJSON();
    }

    public static PepfullApplication getInstance() {

        return pepApplicationInstance;
    }

    public static void setPerfilEgresoResponse(PEgreso perfilEgresoResponse) {
        PepfullApplication.perfilEgresoResponse = perfilEgresoResponse;
    }

    public static PEgreso getPerfilEgresoResponse() {
        return perfilEgresoResponse;
    }

    public static List<Telegraph> getListTelegraph() {
        return listTelegraph;
    }

    public static void setListTelegraph(List<Telegraph> listTelegraph) {
        PepfullApplication.listTelegraph = listTelegraph;
    }

    public static void setListTelephone(List<Telephone> listTelephone) {
        PepfullApplication.listTelephone = listTelephone;
    }

    public static List<Telephone> getListTelephone() {
        return listTelephone;
    }

    public static List<Radio> getListRadio() {
        return listRadio;
    }

    public static void setListRadio(List<Radio> radio) {
        PepfullApplication.listRadio = radio;
    }

    public static void setIsSubContent(boolean isSubContent) {
        PepfullApplication.isSubContent = isSubContent;
    }

    public static PProfesional getpProfesional() {
        return pProfesional;
    }

    public static void setpProfesional(PProfesional pProfesional) {
        PepfullApplication.pProfesional = pProfesional;
    }

    public static POcupacional getpOcupacional() {
        return pOcupacional;
    }

    public static void setpOcupacional(POcupacional pOcupacional) {
        PepfullApplication.pOcupacional = pOcupacional;
    }

    public static PPrograma getpPrograma() {
        return pPrograma;
    }

    public static void setpPrograma(PPrograma pPrograma) {
        PepfullApplication.pPrograma = pPrograma;
    }

    public static boolean isIsSubContent() {
        return isSubContent;
    }
}
