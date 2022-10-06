package com.example.androidlaravelcrud.remote;

public class APIUtils {

    private APIUtils(){

    }

    public static final String API_URL = "http://192.168.235.27:8080";


    public static StudentService getStudentService() {
        return RetrofitClient.getClient(API_URL).create(StudentService.class);
    }


}
