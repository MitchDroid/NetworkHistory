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
import co.com.mjbarrera.app.network.domain.Internet.Internet;
import co.com.mjbarrera.app.network.domain.Modem.Modem;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.FirstWireless;
import co.com.mjbarrera.app.network.domain.Wireless.Wireless;
import co.com.mjbarrera.app.network.domain.radio.Radio;
import co.com.mjbarrera.app.network.domain.telegraph.Telegraph;
import co.com.mjbarrera.app.network.domain.telephone.Telephone;

/**
 * Created by Personal on 25/10/2014.
 */
public class JSONHandler {

    private static PepfullApplication pepApplication = PepfullApplication
            .getInstance();

    private static List<Telegraph> listTelegraph;
    private static List<Telephone> listItemsTelehpone;
    private static List<Radio> listItemsRadio;
    private static List<Wireless> listWireless;
    private static List<Modem> listModem;
    private static List<Internet> listInternet;
    private static List<FirstWireless> listFirstWireless;




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

    /*return Wireless from JSON element*/
    public static void getWirelessFromJSON() {
        int rawFile = R.raw.wireless;

        listWireless = new ArrayList<>();

        // Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                Wireless data = new Wireless();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listWireless.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        PepfullApplication.setListWireless(listWireless);
    }

    /*return Modem from JSON element*/
    public static void getModemFromJSON() {
        int rawFile = R.raw.modem;

        listModem = new ArrayList<>();

// Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                Modem data = new Modem();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listModem.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        PepfullApplication.setListModem(listModem);
    }


    /*return Internet from JSON element*/
    public static void getInternetFromJSON() {
        int rawFile = R.raw.internet;

        listInternet = new ArrayList<>();


// Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                Internet data = new Internet();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listInternet.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        PepfullApplication.setListInternet(listInternet);
    }

    /*return FirstWireless from JSON element*/
    public static void getFirstWirelessFromJSON() {
        int rawFile = R.raw.fwireless;

        listFirstWireless = new ArrayList<>();

        // Try to parse JSON
        try {
            //read JSON from resources
            String sGetDataFromJSONFiles = readJSONFile(rawFile);
            // Creating JSONObject from String
            JSONObject jsonObjMain = new JSONObject(sGetDataFromJSONFiles);

            // Creating JSONArray from JSONObject
            JSONArray jsonArray = jsonObjMain.getJSONArray("maincontent");

            for (int i = 0; i < jsonArray.length(); i++) {
                FirstWireless data = new FirstWireless();
                // Creating JSONObject from JSONArray
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Getting data from individual JSONObject
                String id = jsonObj.getString("id");
                String content = jsonObj.getString("content");

                // Append result to TextView
                data.setId(id);
                data.setContent(content);

                listFirstWireless.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        PepfullApplication.setListFirstWireless(listFirstWireless);

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