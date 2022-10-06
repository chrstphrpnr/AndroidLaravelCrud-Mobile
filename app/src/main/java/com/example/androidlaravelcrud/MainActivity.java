package com.example.androidlaravelcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidlaravelcrud.models.Student;
import com.example.androidlaravelcrud.remote.APIUtils;
import com.example.androidlaravelcrud.remote.StudentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView studentlistview;
    StudentService studentService;
    List<Student> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentlistview = findViewById(R.id.studentlistview);
        studentService = APIUtils.getStudentService();


        getStudentList();



    }

    public void getStudentList(){
        Call<Student> call = studentService.getStudents();

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if(response.body() != null){
                    list = response.body().getData();
                }
                studentlistview.setAdapter(new StudentAdapter(MainActivity.this, R.layout.list_student, list));
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.e("Error: ", t.getMessage());
            }
        });

    }



}