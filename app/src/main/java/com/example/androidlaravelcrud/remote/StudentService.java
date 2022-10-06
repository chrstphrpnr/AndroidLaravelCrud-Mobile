package com.example.androidlaravelcrud.remote;

import com.example.androidlaravelcrud.models.Student;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentService {

    @GET("api/students/")
    Call<Student> getStudents();

    @POST("api/students/")
    Call<Student> addStudent(@Body Student student);

    @PUT("api/students/{id}")
    Call<Student> updateStudent(@Path("id") int id, @Body Student student);

    @DELETE("api/students/{id}")
    Call<Student> deleteStudent(@Path("id") int id);


}
