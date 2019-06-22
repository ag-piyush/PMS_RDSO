/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.pms_rdso;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ProjectAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Project} objects.
 */
public class ProjectAdapter extends ArrayAdapter<Project> {

    /** Resource ID for the background color for this list of projects */
    private int mColorResourceId;

    /**
     * Create a new {@link ProjectAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param projects is the list of {@link Project}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of projects
     */
    public ProjectAdapter(Context context, ArrayList<Project> projects, int colorResourceId) {
        super(context, 0, projects);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Project} object located at this position in the list
        Project currentProject = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID project_name_text_view.
        TextView projectNameTextView = (TextView) listItemView.findViewById(R.id.project_name_text_view);

        projectNameTextView.setText(currentProject.getProjectName());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}