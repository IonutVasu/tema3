package com.example.tema3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private JSONArray mDataset;
    private View.OnClickListener onClickListener;

    MyAdapter(JSONArray objects){
        mDataset = objects;

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mydebug", "click");
            }
        };
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;

        MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_blank, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        try{
            JSONObject json = mDataset.getJSONObject(position);
            String name = json.getString("name");
            final int id = Integer.parseInt(json.getString("id"));
            holder.nameTextView.setText(name);
            holder.nameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment1.loadTodos(id);
                }
            });
        }catch (JSONException e){
        }

    }

    @Override
    public int getItemCount() {
        return mDataset.length();
    }


}