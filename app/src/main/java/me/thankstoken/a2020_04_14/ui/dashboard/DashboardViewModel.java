package me.thankstoken.a2020_04_14.ui.dashboard;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import me.thankstoken.a2020_04_14.R;

public class DashboardViewModel extends ViewModel {

    private static final String TAG = "DashboardViewModel";
    private static final String URL ="https://restcountries.eu/rest/v2/name/united";

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Country>> countrys;



    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Country>> getCountrys() {
        if (countrys == null) {
            countrys = new MutableLiveData<List<Country>>();
            loadCountrys();
        }
        return countrys;
    }

    private void loadCountrys() {
        // Do an asynchronous operation to fetch users.

    }

    public void basicQueue(View view) {
        final TextView textView = (TextView) view.findViewById(R.id.text_view);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(view.getContext());

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 50 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,50));
                        Log.i(TAG,response);

                        Gson gson = new Gson();
                        Country countrys[] = gson.fromJson(response, Country[].class);
                        for (int i = 0; i < countrys.length; i++) {
                            Log.i(TAG,countrys[i].toString());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG,error.getMessage().toString());
                textView.setText("Failed!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}