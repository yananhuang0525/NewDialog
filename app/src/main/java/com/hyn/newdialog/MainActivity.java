package com.hyn.newdialog;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.EffectsType;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button button, button1, button2, button3;
    private EffectsType effectstype;
    private NiftyDialogBuilder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                effectstype = EffectsType.Newspager;
                break;
            case R.id.button1:
                effectstype = EffectsType.Slidetop;
                break;
            case R.id.button2:
                effectstype = EffectsType.Fall;
                break;
            case R.id.button3:
                effectstype = EffectsType.RotateBottom;
                break;
        }
        dialogBuilder = NiftyDialogBuilder.getInstance(MainActivity.this);
        dialogBuilder.withTitle("提示").withMessage("这是一个提示框")
                .withEffect(effectstype).withDialogColor("#90d7ec")
                .withButton1Text("确定")
                .withButton2Text("取消").isCancelableOnTouchOutside(false)
                .setCustomView(R.layout.custom_view, view.getContext()).setButton1Click(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "确定按钮", Toast.LENGTH_LONG).show();
            }
        }).setButton2Click(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.dismiss();
            }
        }).show();
    }
}
