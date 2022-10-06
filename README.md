# AndroidLaravelCrud-Mobile


### Add dependencies to build.gradle then sync

```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.google.code.gson:gson:2.9.0'
```

### Create Package in the main folder named "models" then create java class named based on your database table

### Student.java

```
\\Declaration of Variables
private List<Student> data;

@SerializedName("id")
@Expose
private int id;

@SerializedName("first_name")
@Expose
private String first_name;


@SerializedName("last_name")
@Expose
private String last_name;


@SerializedName("age")
@Expose
private int age;

//Constructor
public Student(int id, String first_name, String last_name, int age) {
    this.setId(id);
    this.setFirst_name(first_name);
    this.setLast_name(first_name);
    this.setAge(age);
}


//Setters and Getters
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getFirst_name() {
    return first_name;
}

public void setFirst_name(String first_name) {
    this.first_name = first_name;
}

public String getLast_name() {
    return last_name;
}

public void setLast_name(String last_name) {
    this.last_name = last_name;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public List<Student> getData() {
    return data;
}

public void setData(List<Student> data) {
    this.data = data;
}
```

### Create another package inside the main folder and name it "remote"
### Create a java class interface named "Student"Service and declare this

```
@GET("api/students/")
Call<Student> getStudents();

@POST("api/students/")
Call<Student> addStudent(@Body Student student);

@PUT("api/students/{id}")
Call<Student> updateStudent(@Path("id") int id, @Body Student student);

@DELETE("api/students/{id}")
Call<Student> deleteStudent(@Path("id") int id);
```

### Create another java class inside remote package named "RetrofitClient" this is the connection for the retrofitclient that used to connect to database
```
private static Retrofit retrofit;

public static Retrofit getClient(String url){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
}
```

### Create another java class inside remote package named APIUtils
```
private APIUtils(){

}

public static final String API_URL = "http://000.000.0000.0000:8080";  //ipconfig in cmd to get your ip address and put it on API_URL

public static StudentService getUserService() {
    return RetrofitClient.getClient(API_URL).create(StudentService.class);
}
```











