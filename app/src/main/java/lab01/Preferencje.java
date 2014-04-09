package lab01;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.myapplication2.app.R;

/**
 * Created by SG0217297 on 4/9/2014.
 */
public class Preferencje extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
