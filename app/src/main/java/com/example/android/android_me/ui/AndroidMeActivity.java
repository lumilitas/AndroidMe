/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        int head = getIntent().getExtras().getInt("headIndex");
        int body = getIntent().getExtras().getInt("bodyIndex");
        int leg = getIntent().getExtras().getInt("legIndex");

        if (savedInstanceState == null) {
            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legFragment = new BodyPartFragment();

            headFragment.setmImageIds(AndroidImageAssets.getHeads());
            headFragment.setmListIndex(head);
            bodyFragment.setmImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setmListIndex(body);
            legFragment.setmImageIds(AndroidImageAssets.getLegs());
            legFragment.setmListIndex(leg);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.headContainer, headFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.bodyContainer, bodyFragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.legContainer, legFragment)
                    .commit();
        }
    }
}
