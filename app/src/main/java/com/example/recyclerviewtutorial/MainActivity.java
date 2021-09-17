package com.example.recyclerviewtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.recyclerviewtutorial.models.DashboardCardDetails;
import com.example.recyclerviewtutorial.pojo.DashboardPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    List<ModelClass>serviceList;
    Adapter adapter;
    private static final String TAG = "MainActivity";
    private Button getresultdata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getresultdata = findViewById(R.id.getresultdata);

        getresultdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getSupportActionBar().hide();

        getDashboardData();

    }

    private void getDashboardData() {
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<DashboardPojo> call = methods.getAllresultdata();

        call.enqueue(new Callback<DashboardPojo>() {
            @Override
            public void onResponse(Call<DashboardPojo> call, Response<DashboardPojo> response) {
                Log.e(TAG,"onResponse:code:  "+response.code());
                DashboardPojo pojo = response.body();
                ArrayList <DashboardCardDetails> cardsList = pojo.getResultdata();
                if (response.isSuccessful()){
                setDashboardData(response.body().getResultdata());
                }else{
                    Toast.makeText(getApplicationContext(),"please try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DashboardPojo> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );

            }
        });
    }

    private void setDashboardData(ArrayList<DashboardCardDetails> cardsList) {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(cardsList);
        recyclerView.setAdapter(adapter);

    }

  /*  private void initData() {
        serviceList = new ArrayList<>();
        serviceList.add(new ModelClass(R.drawable.ic_baby,"Baby Sitting and Child Care"));
        serviceList.add(new ModelClass(R.drawable.ic_home,"In-Home Care"));
        serviceList.add(new ModelClass(R.drawable.ic_care,"Senior Care"));
        serviceList.add(new ModelClass(R.drawable.pet,"Pet Care"));
        serviceList.add(new ModelClass(R.drawable.ic_nurse,"Nurse Care"));
        serviceList.add(new ModelClass(R.drawable.tasker,"Tasker"));
    }*/

    private void initRecyclerView() {

        /*recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(serviceList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();*/
    }
}