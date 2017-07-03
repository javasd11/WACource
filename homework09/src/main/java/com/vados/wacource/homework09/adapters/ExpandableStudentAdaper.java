package com.vados.wacource.homework09.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.vados.wacource.homework09.R;
import com.vados.wacource.homework09.models.Group;
import com.vados.wacource.homework09.models.Student;

import java.util.ArrayList;

/**
 * Created by vadim on 02.07.2017.
 */

public class ExpandableStudentAdaper extends BaseExpandableListAdapter {
    private ArrayList<Group> mGroups;
    private int mGroupResource;
    private int mChildResource;
    private LayoutInflater mInflater;

    public ExpandableStudentAdaper(Context context, ArrayList<Group> groups, int groupREsource, int studentREsource) {
        mGroups = groups;
        mGroupResource = groupREsource;
        mChildResource = studentREsource;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        Group group = mGroups.get(groupPosition);
        return group.students == null ? 0 : group.students.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).students[childPosition];
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mGroupResource, null);
        TextView textView =  (TextView) convertView.findViewById(R.id.txtViewGrouptName);

        Group group = mGroups.get(groupPosition);

        if(isExpanded){
            textView.setTextColor(Color.BLUE);
        }
        else{
            textView.setTextColor(Color.BLACK);
        }

        textView.setText(group.GroupName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mChildResource, null);

        Student student =  mGroups.get(groupPosition).students[childPosition];

        ((TextView) convertView.findViewById(R.id.txtViewFirstName)).setText(student.firstName);
        ((TextView) convertView.findViewById(R.id.txtViewLastName)).setText(student.lastName);
        ((TextView) convertView.findViewById(R.id.txtViewAge)).setText(String.valueOf(student.age));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

}
