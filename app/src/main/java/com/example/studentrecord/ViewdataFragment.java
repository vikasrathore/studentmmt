package com.example.studentrecord;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ViewdataFragment extends Fragment {
    ListView listView;
    RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    public ViewdataFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewdata, container, false);


        recyclerView = view.findViewById(R.id.recyc_showdata);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

       // databaseHelper =new DatabaseHelper(getContext());
populateRecyclerView();
return view;

    }
    private void populateRecyclerView(){
       // Log.e(TAB,"Data in Show Data");
      //  Cursor date=databaseHelper.getData();

    }
    }