package co.com.mjbarrera.app.network.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.PEgreso;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.PEgresoFunciones;
import co.com.mjbarrera.app.network.domain.PerfilOcupacional.POcupacional;
import co.com.mjbarrera.app.network.domain.PerfilOcupacional.POcupacionalPerfil;
import co.com.mjbarrera.app.network.domain.PerfilProfesional.PProfesional;
import co.com.mjbarrera.app.network.domain.PerfilProfesional.PProfesionalPerfil;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PPrograma;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PProgramaConocimientos;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PProgramaHabilidades;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PProgramaPerfil;
import co.com.mjbarrera.app.network.domain.radio.Radio;
import co.com.mjbarrera.app.network.domain.telephone.Telephone;
import co.com.mjbarrera.app.network.domain.telegraph.Telegraph;

/**
 * Created by Personal on 25/10/2014.
 */
public class JSONHandler {

    private static PepfullApplication pepApplication = PepfullApplication
            .getInstance();

    private static ArrayList<Telegraph> listTelegraph;
    /*Telefono*/

    private static List<Telephone> listItemsTelehpone;
    private static List<Radio> listItemsRadio;

    /*Perfil del programa*/
    private static PPrograma pprograma;
    private static List<PProgramaPerfil> listPerfil;
    private static List<PProgramaConocimientos> listConocimientos;
    private static List<PProgramaHabilidades> listHabilidades;

    /*Perfil Ocupacional*/
    private static POcupacional pocupacional;
    private static List<POcupacionalPerfil> listPerfilOcupacional;

    /*Perfil profesional*/
    private static PProfesional pprofesional;
    private static List<PProfesionalPerfil> listProPerfil;

    /*Perfil Egreso*/
    private static PEgreso pegreso;
    private static List<PEgresoFunciones> listEgreso;


    /*return Telegraph from JSON element*/
    public static void getTelegraphFromJSON() {
        int rawFile = R.raw.telegraph;

        listTelegraph = new ArrayList<>();

        // Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                Telegraph data = new Telegraph();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listTelegraph.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        pepApplication.setListTelegraph(listTelegraph);

    }

    /*return Telephone from JSON element*/
    public static void getTelephoneFromJSON() {

        int rawFile = R.raw.telephone;

        listItemsTelehpone = new ArrayList<>();

        // Try to parse JSON

        // Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                Telephone data = new Telephone();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listItemsTelehpone.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        PepfullApplication.setListTelephone(listItemsTelehpone);

    }

    /*return Radio from JSON element*/
    public static void getRadioFromJSON() {

        int rawFile = R.raw.radio;

        listItemsRadio = new ArrayList<>();

        // Try to parse JSON

        // Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                Radio data = new Radio();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listItemsRadio.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        PepfullApplication.setListRadio(listItemsRadio);

    }

    /*return PerfilPrograma from JSON element*/
    public static void getPProgramaFromJSON() {
        int rawFile = R.raw.perfilprograma;

        pprograma = new PPrograma();
        listPerfil = new ArrayList<PProgramaPerfil>();
        listConocimientos = new ArrayList<PProgramaConocimientos>();
        listHabilidades = new ArrayList<PProgramaHabilidades>();

        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);

            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            JSONObject object = jsonObjMain.getJSONObject("programa");

            String title = object.getString("title");
            String content = object.getString("content");

            pprograma.setTitle(title);
            pprograma.setContent(content);

            JSONArray jsonArrayPerfil = object.getJSONArray("perfil");
            for (int i = 0; i < jsonArrayPerfil.length(); i++) {
                JSONObject objperfil = jsonArrayPerfil.getJSONObject(i);
                PProgramaPerfil pperfil = new PProgramaPerfil();

                String _id = objperfil.getString("id");
                String _content = objperfil.getString("content");

                pperfil.setId(_id);
                pperfil.setContent(_content);

                listPerfil.add(pperfil);
                pprograma.setListPefil(listPerfil);
            }

            JSONArray jsonArrayConocimiento = object.getJSONArray("conocimientos");
            for (int i = 0; i < jsonArrayConocimiento.length(); i++) {
                JSONObject objConocimiento = jsonArrayConocimiento.getJSONObject(i);
                PProgramaConocimientos ppconocimiento = new PProgramaConocimientos();

                String _id = objConocimiento.getString("id");
                String _content = objConocimiento.getString("content");

                ppconocimiento.setId(_id);
                ppconocimiento.setContent(_content);

                listConocimientos.add(ppconocimiento);
                pprograma.setListConocimientos(listConocimientos);
            }

            JSONArray jsonArrayHabilidades = object.getJSONArray("habilidades");
            for (int i = 0; i < jsonArrayHabilidades.length(); i++) {
                JSONObject objHabilidades = jsonArrayHabilidades.getJSONObject(i);
                PProgramaHabilidades pphabilidades = new PProgramaHabilidades();

                String _id = objHabilidades.getString("id");
                String _content = objHabilidades.getString("content");

                pphabilidades.setId(_id);
                pphabilidades.setContent(_content);

                listHabilidades.add(pphabilidades);
                pprograma.setListHabilidades(listHabilidades);
            }

        } catch (JSONException js) {
            js.printStackTrace();
        }

        PepfullApplication.setpPrograma(pprograma);
    }

    /*return PerfilProfesional from JSON element*/
    public static void getPProfesionalFromJSON() {
        int rawFile = R.raw.perfilprofesional;
        pprofesional = new PProfesional();
        listProPerfil = new ArrayList<PProfesionalPerfil>();


        try {

            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);

            JSONObject object = new JSONObject(sGetDataFromJSONFiles);
            JSONObject main = object.getJSONObject("profesional");

            String _title = main.getString("title");
            String _content = main.getString("content");

            pprofesional.setTitle(_title);
            pprofesional.setContent(_content);

            JSONArray jsonArrayPProfesional = main.getJSONArray("perfil");

            for (int i = 0; i < jsonArrayPProfesional.length(); i++) {
                JSONObject _object = jsonArrayPProfesional.getJSONObject(i);
                PProfesionalPerfil perfil = new PProfesionalPerfil();

                String _id = _object.getString("id");
                String _contentt = _object.getString("content");

                perfil.setId(_id);
                perfil.setContent(_contentt);

                listProPerfil.add(perfil);
                pprofesional.setListPerfil(listProPerfil);

            }
        } catch (JSONException js) {
            js.printStackTrace();
        }


        PepfullApplication.setpProfesional(pprofesional);
    }


    /*return PerfilOcupacional from JSON element*/
    public static void getPerfilOcupacionalDaraFromJSON() {
        int rawFile = R.raw.perfilocupacional;
        pocupacional = new POcupacional();
        listPerfilOcupacional = new ArrayList<POcupacionalPerfil>();

        String sGetDataFromJSONFiles;

        try {
            //read JSON from resources
            sGetDataFromJSONFiles = loadFromFile(rawFile);

            JSONObject object = new JSONObject(sGetDataFromJSONFiles);
            JSONObject content = object.getJSONObject("ocupacional");

            String _title = content.getString("title");
            String _content = content.getString("content");

            pocupacional.setTitle(_title);
            pocupacional.setContent(_content);

            JSONArray jsonPerfiOcupacionalArray = content.getJSONArray("perfil");

            for (int i = 0; i < jsonPerfiOcupacionalArray.length(); i++) {
                JSONObject contentArray = jsonPerfiOcupacionalArray.getJSONObject(i);
                POcupacionalPerfil perfil = new POcupacionalPerfil();
                perfil.setId(contentArray.getString("id"));
                perfil.setContent(contentArray.getString("content"));

                listPerfilOcupacional.add(perfil);
                pocupacional.setListPerfil(listPerfilOcupacional);
            }


        } catch (JSONException js) {
            js.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }

        PepfullApplication.setpOcupacional(pocupacional);
    }

    /*return PerfilEgreso from JSON element*/
    public static void getPerfilEgresoDataFromJSON() {
        int rawFile = R.raw.perfilegreso;
        pegreso = new PEgreso();
        listEgreso = new ArrayList<PEgresoFunciones>();

        String sGetDataFromJSONFiles;

        try {
            //read JSON from resources
            sGetDataFromJSONFiles = loadFromFile(rawFile);

            JSONObject object = new JSONObject(sGetDataFromJSONFiles);
            JSONObject content = object.getJSONObject("egreso");

            String _title = content.getString("title");
            String content_uno = content.getString("content_uno");
            String content_dos = content.getString("content_dos");

            pegreso.setTitle(_title);
            pegreso.setContent_uno(content_uno);
            pegreso.setContent_dos(content_dos);

            JSONArray jsonPerfiOcupacionalArray = content.getJSONArray("funciones");

            for (int i = 0; i < jsonPerfiOcupacionalArray.length(); i++) {
                JSONObject contentArray = jsonPerfiOcupacionalArray.getJSONObject(i);
                PEgresoFunciones funciones = new PEgresoFunciones();
                funciones.setId(contentArray.getString("id"));
                funciones.setContent(contentArray.getString("content"));

                listEgreso.add(funciones);
                pegreso.setListFunciones(listEgreso);
            }
            pepApplication.setPerfilEgresoResponse(pegreso);

        } catch (JSONException js) {
            js.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }


    }


    /*read and return JSONFile object*/
    private static String readJSONFile(int id) {
        // Reading text file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        String myjsonstring = "";
        try {
            br = new BufferedReader(new InputStreamReader(pepApplication.getResources().openRawResource(id)));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        myjsonstring = sb.toString();

        return myjsonstring;

    }

    /*ig-JSON-PARSER*/
    public static String loadFromFile(int resourceId) throws IOException {
        InputStreamReader inputStreamReader = null;
        try {

            inputStreamReader =
                    new InputStreamReader(pepApplication.getResources().openRawResource(resourceId));
            StringBuilder sb = new StringBuilder();
            char[] buffer = new char[8 * 1024];
            int bytesRead;

            while ((bytesRead = inputStreamReader.read(buffer)) != -1) {
                sb.append(buffer, 0, bytesRead);
            }

            return sb.toString();
        } finally {
            inputStreamReader.close();
        }
    }
}