package titlepage.cinema.com.localisationmenu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.prgguru.android.R;

import java.util.Locale;

public class MainActivity extends Activity {

    Spinner spinnerctrl;
   // Button btn;
    Locale myLocale;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerctrl = (Spinner) findViewById(R.id.spinner1);
        spinnerctrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {

                if (pos == 1) {

                    Toast.makeText(parent.getContext(),"You have selected Tamil", Toast.LENGTH_SHORT).show();
                    setLocale("ta");
                } else if (pos == 2) {

                    Toast.makeText(parent.getContext(),"You have selected Hindi", Toast.LENGTH_SHORT).show();
                    setLocale("hi");
                } else if (pos == 3) {

                    Toast.makeText(parent.getContext(), "You have selected English", Toast.LENGTH_SHORT).show();
                    setLocale("en");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
    }
}
