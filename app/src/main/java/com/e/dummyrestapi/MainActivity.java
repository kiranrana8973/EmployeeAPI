package com.e.dummyrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.e.dummyrestapi.API.EmployeeAPI;
import com.e.dummyrestapi.URL.Url;
import com.e.dummyrestapi.model.Employee;
import com.e.dummyrestapi.response.EmployeeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EmployeeAPI employeeAPI = Url.getInstance().create(EmployeeAPI.class);

        Call<EmployeeResponse> listCall = employeeAPI.getAllEmployee();

        listCall.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Error : " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Employee> employeeList = response.body().getData();
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}