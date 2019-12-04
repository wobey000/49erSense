package com.example.a49ersense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecurityFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_security, container, false);

        Button locks = (Button) v.findViewById(R.id.lock_button);
        Button videoFeed = (Button) v.findViewById(R.id.video_button);
        Button motion = (Button) v.findViewById(R.id.motion_button);
        Button garage = (Button) v.findViewById(R.id.garage_button);
        locks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Locks_Activity.class);
                startActivity(intent);
            }
        });
        videoFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), video_feeds.class);
                startActivity(intent);
            }
        });

        motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), motion_sensors.class);
                startActivity(intent);
            }
        });

        garage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Garage_Doors.class);
                startActivity(intent);
            }
        });

        return v;
    }
}










