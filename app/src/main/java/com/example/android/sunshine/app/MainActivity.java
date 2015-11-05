package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ArrayAdapter<String> mForecastAdapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            /*
            ArrayList<String> nombreArrayList = new ArrayList<String>();
            nombreArrayList.add("Today-sunny-88/63");
            nombreArrayList.add("Tomorrow-Froggy 70/63");
            nombreArrayList.add("Weds-coudy-72/63");
            nombreArrayList.add("Thus-Rainy 64/51");
            nombreArrayList.add("Fri-Froggy -70/46");
            nombreArrayList.add("Sat-Sunny-76/68");
            nombreArrayList.add("Elemento");
*/
            String[] forecastArray={"Today-sunny-88/63","Tomorrow-Froggy 70/63",
            "Weds-coudy-72/63","Thus-Rainy 64/51","Fri-Froggy -70/46","Sat-Sunny-76/68"};

            List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

            mForecastAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,weekForecast);
            ListView listView = (ListView) rootView.findViewById(R.id.listView_feracast);
            listView.setAdapter(mForecastAdapter);
            return rootView;
        }
    }
}
