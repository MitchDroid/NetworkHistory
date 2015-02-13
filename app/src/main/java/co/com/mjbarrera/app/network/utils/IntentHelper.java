package co.com.mjbarrera.app.network.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;
import co.com.mjbarrera.app.network.ui.activities.MenuActivity;

public class IntentHelper {

    private static Context mContext = PepfullApplication
            .getInstance().getApplicationContext();

    public static void goToHomeActivity(Activity activity) {
        launchItent(activity, MenuActivity.class);

    }

    private static <T> Intent launchItent(Activity activity, Class<T> className) {
        Intent myIntent = new Intent(mContext, className);
        activity.startActivity(myIntent);
        return myIntent;
    }


    /*Open PDF File*/
    public static void goToFile(String path) throws Exception {
        File targetFile = new File(path);
        Uri targetUri = Uri.fromFile(targetFile);
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setDataAndType(targetUri, "application/pdf");
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PepfullApplication.getInstance().startActivity(myIntent);
    }

    public static Intent shareIntent(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, mContext.getResources().getString(R.string.share_content));
        sendIntent.setType("text/plain");

        return sendIntent;
    }

}
