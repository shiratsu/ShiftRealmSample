package indival.co.jp.shiftrealmsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import indival.co.jp.shiftrealmsample.model.Migration;
import io.realm.exceptions.RealmMigrationNeededException;


/**
 * Created by Shunsuke Hiratsuka <hiratsukashu@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public class SplashActivity extends Activity
{
    public static final String TAG = SplashActivity.class.getName();

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) throws RealmMigrationNeededException {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        // レルムデータの書き出し
        copyBundledRealmFile(getResources().openRawResource(R.raw.shift_for_shuhu), getString(R.string.realm_file_name));
        //Realm.getInstance(this, "shift_for_shuhu");

        // 2秒したらMainActivityを呼び出してSplashActivityを終了する
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // MainActivityを呼び出す
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                // SplashActivityを終了する
                SplashActivity.this.finish();
            }
        }, 2 * 1000); // 2000ミリ秒後（2秒後）に実行
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler = null;
    }

    /**
     * Realmデータをファイルに出力する
     */
    private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
            return file.getAbsolutePath();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
