package org.apache.cordova.settings;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;
import java.lang.Exception;

/**
 * This class echoes a string called from JavaScript.
 */
public class Settings extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("systemNoticeSetting")) {
            this.systemNoticeSetting(callbackContext);
            return true;
        }else if(action.equals("securitySettings")){
            this.actionSecuritySettings(callbackContext);
            return true;
        }
        return false;
    }

    private void systemNoticeSetting(CallbackContext callbackContext) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", this.cordova.getActivity().getPackageName(), null);
        intent.setData(uri);
        cordova.getActivity().startActivity(intent);
        callbackContext.success();
    }

    private void actionSecuritySettings(CallbackContext callbackContext) throws JSONException {

        try {
            cordova.getActivity().startActivity(new Intent(Settings.ACTION_SETTINGS));
            //Toast.makeText(cordova.getContext(), "成功调用方法", Toast.LENGTH_SHORT).show();
            callbackContext.success("success");
        } catch (Exception e) {
            e.printStackTrace();
            callbackContext.error("failed");
        }
    }
}
