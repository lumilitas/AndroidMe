package com.example.android.android_me.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallback;

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + "must implement OnImageClickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // Inflate the Android-Me fragment layout
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        GridView gridView = (GridView) rootView.findViewById(R.id.imagesGridView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCallback.onImageSelected(position);
            }
        });

        // Return root view
        return rootView;
    }
}
