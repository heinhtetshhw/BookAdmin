package com.shhw.audiobookadminapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    ArrayList<String> arrayList = new ArrayList<>();
    Context context;
    FragmentManager fm;

    public UserAdapter(ArrayList<String> arrayList, Context context, FragmentManager fm) {
        this.arrayList = arrayList;
        this.context = context;
        this.fm = fm;
    }


    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.useritem,
                parent,
                false
        );
        UserHolder userHolder = new UserHolder(myView);
        return  userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {

        holder.userName.setText(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder{
        TextView userName;
        public UserHolder(@NonNull View itemView) {

            super(itemView);
            userName =itemView.findViewById(R.id.userName);
        }
    }
}
