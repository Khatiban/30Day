package com.android.fury.a30day.alarm;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.fury.a30day.R;
import com.android.fury.a30day.menu_view.setting_alarm;
import com.google.firebase.crash.FirebaseCrash;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DialogUniversalInfoUtils {

    private Dialog mDialog;
    private TextView mDialogHeader;
    private ImageView mDialogImage;
    private TextView mDialogOKButton;
    private TextView dialog_universal_info_text_7;
    private setting_alarm mDialogUniversalInfoActivity;


    public DialogUniversalInfoUtils(setting_alarm var1) {
        this.mDialogUniversalInfoActivity = var1;
    }

    private void initDialogButtons() {
        this.mDialogOKButton.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
                DialogUniversalInfoUtils.this.mDialog.dismiss();
            }
        });
        dialog_universal_info_text_7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    huaweiProtectedApps();
                }catch (Exception e){
                    FirebaseCrash.report(new Exception("not hawaie"));
                    Toast.makeText(mDialogUniversalInfoActivity, "متاسفانه گوشی شما این قابلیت را ندارد", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void dismissDialog() {
        this.mDialog.dismiss();
    }

    public void showDialog() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mDialogUniversalInfoActivity, R.style.CustomDialogTheme);
        }
        this.mDialog.setContentView(R.layout.dialog_universal_info);
        this.mDialog.setCancelable(true);
        this.mDialog.show();
        this.mDialogOKButton = (TextView) this.mDialog.findViewById(R.id.dialog_universal_info_ok);
        this.dialog_universal_info_text_7 = (TextView) this.mDialog.findViewById(R.id.dialog_universal_info_text_7);
        ScrollView sView = (ScrollView) mDialog.findViewById(R.id.sc_why);
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);
        initDialogButtons();
        FirebaseCrash.log("log 1");
    }



    private void huaweiProtectedApps() {
        try {
            String cmd = "am start -n com.huawei.systemmanager/.optimize.process.ProtectActivity";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                cmd += " --user " + getUserSerial();
            }
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ignored) {
        }
    }

    private String getUserSerial() {
        //noinspection ResourceType
        Object userManager = mDialogUniversalInfoActivity.getSystemService("user");
        if (null == userManager) return "";

        try {
            Method myUserHandleMethod = android.os.Process.class.getMethod("myUserHandle", (Class<?>[]) null);
            Object myUserHandle = myUserHandleMethod.invoke(android.os.Process.class, (Object[]) null);
            Method getSerialNumberForUser = userManager.getClass().getMethod("getSerialNumberForUser", myUserHandle.getClass());
            Long userSerial = (Long) getSerialNumberForUser.invoke(userManager, myUserHandle);
            if (userSerial != null) {
                return String.valueOf(userSerial);
            } else {
                return "";
            }
        } catch (NoSuchMethodException | IllegalArgumentException | InvocationTargetException | IllegalAccessException ignored) {
        }
        return "";
    }


}




