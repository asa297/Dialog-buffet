package rattanapol.utcc.ac.th.testarea;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int ID_STANDARD_DIALOG = R.id.btn_standard_dialog;
    Button btn ;
    ImageView iconView; private LovelySaveStateHandler saveStateHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        saveStateHandler = new LovelySaveStateHandler();

        btn = (Button) findViewById(R.id.btn_standard_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do something when the corky3 is clicked
                try {
                    showLovelyDialog(v.getId(), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
    private void showLovelyDialog(int dialogId, Bundle savedInstanceState) throws IOException {
        switch (dialogId) {
            case ID_STANDARD_DIALOG:
                showStandardDialog(savedInstanceState);
                break;

        }
    }

    private void showStandardDialog(Bundle savedInstanceState) throws IOException {

//        URL url = new URL("https://img.kapook.com/u/surauch/cook/Easy01.jpg");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setDoInput(true);
//        connection.connect();
//        InputStream input = connection.getInputStream();
//
//        Bitmap myBitmap = BitmapFactory.decodeStream(input);

        new LovelyStandardDialog(this)
                .setTopColorRes(R.color.indigo)
                .setButtonsColorRes(R.color.darkDeepOrange)
                .setIcon1(R.drawable.test)
                .setTitle(R.string.rate_title)
                .setInstanceStateHandler(ID_STANDARD_DIALOG, saveStateHandler)
                .setSavedInstanceState(savedInstanceState)
                .setMessage(R.string.rate_message)
                .setPositiveButton(android.R.string.ok, LovelyDialogCompat.wrap(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                R.string.repo_waiting,
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }))
                .setNeutralButton(R.string.later, null)
                .setNegativeButton(android.R.string.no, null)
                .show();

    }


}
