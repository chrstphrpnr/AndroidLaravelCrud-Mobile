package com.example.androidlaravelcrud;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidlaravelcrud.models.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private List<Student> students;


    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.students = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_student, parent, false);

        TextView txtStudentId = (TextView)rowView.findViewById(R.id.txtStudentId);
        TextView txtStudentFirstName = (TextView)rowView.findViewById(R.id.txtStudentFirstName);
        TextView txtStudentLastName = (TextView)rowView.findViewById(R.id.txtStudentLastName);
        TextView txtStudentAge = (TextView)rowView.findViewById(R.id.txtStudentAge);

        txtStudentId.setText(String.format("Student Id: %d", students.get(position).getId()));
        txtStudentFirstName.setText(String.format("First Name: %s", students.get(position).getFirst_name()));
        txtStudentLastName.setText(String.format("Last Name: %s", students.get(position).getLast_name()));
        txtStudentAge.setText(String.format("Age: %d", students.get(position).getAge()));


        return rowView;


    }
}
