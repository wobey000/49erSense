package com.example.a49ersense;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InboxFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v =  inflater.inflate(R.layout.fragment_inbox, container, false);

       // call messages from database
        //listAdapter = new ArrayAdapter<String>(Device_list.this, android.R.layout.simple_list_item_1, devices);
        //devicelist.setAdapter(listAdapter);
       return v;
    }
}
