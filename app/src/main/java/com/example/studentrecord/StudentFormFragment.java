package com.example.studentrecord;

import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StudentFormFragment extends Fragment {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    public static final String TAB = "StudentFormFragment";

    EditText edit_name, edit_rollno, edit_class, edit_fathername, edit_mothernane, edit_phoneno;
    Button btn_submit;


    public StudentFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_studentform, container, false);
        //edit_id=view.findViewById(R.id.textId);
        btn_submit = view.findViewById(R.id.btn_submit);
        edit_name = view.findViewById(R.id.edit_name);
        edit_rollno = view.findViewById(R.id.edit_rollno);
        edit_class = view.findViewById(R.id.edit_class);
        edit_fathername = view.findViewById(R.id.edit_fathername);
        edit_mothernane = view.findViewById(R.id.edit_mothername);
        edit_phoneno = view.findViewById(R.id.edit_phoneno);
        databaseHelper = DatabaseHelper.getInstance(getContext());


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entry = edit_name.getText().toString();
                if (edit_name.length() != 0) {
                    AddData(entry);
                    edit_name.setText("");

                } else {
                    Toast.makeText(getActivity(), "You must fill every field", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public void AddData(String entry) {
        boolean insertdata = databaseHelper.addData(entry);
        if (insertdata) {
            Toast.makeText(getActivity(), "You Have Registered", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Something went Wrong", Toast.LENGTH_SHORT).show();
        }
    }

}
