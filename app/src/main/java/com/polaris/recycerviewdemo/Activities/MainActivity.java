package com.polaris.recycerviewdemo.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.polaris.recycerviewdemo.Adapter.DataAdapter;
import com.polaris.recycerviewdemo.Model.Model;
import com.polaris.recycerviewdemo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
RecyclerView recyclerView;
ArrayList<Model>arrayList;
DataAdapter dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        arrayList=new ArrayList<>();




      praseJsonData();

    }

    private void praseJsonData() {

        RequestQueue queue= Volley.newRequestQueue(this);
        final String url="https://pixabay.com/api/?key=11290772-baf98c38a1ddeead9d8d7f6f6&q=yellow+flowers&image_type=photo&pretty=true";
        StringRequest request=new StringRequest(Request.Method.GET, url, new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray array=jsonObject.getJSONArray("hits");
                            for (int i=0;i<array.length();i++)
                            {
                                JSONObject dataObject=array.getJSONObject(i);
                                String image=dataObject.getString("userImageURL");
                                String user=dataObject.getString("user");
                                String like=dataObject.getString("likes");
                                Model model=new Model(image,user,like);
                                arrayList.add(model);


                            }

                            dataAdapter=new DataAdapter(MainActivity.this,arrayList);
                            recyclerView.setAdapter(dataAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);


    }


}
