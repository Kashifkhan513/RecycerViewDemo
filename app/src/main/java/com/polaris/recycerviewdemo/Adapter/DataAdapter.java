package com.polaris.recycerviewdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.polaris.recycerviewdemo.Model.Model;
import com.polaris.recycerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private Context context;
    private ArrayList<Model>arrayList;


    public DataAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_file,parent,false);
        DataViewHolder dataViewHolder=new DataViewHolder(view);
        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
         Model model=arrayList.get(position);
        Picasso.get().load(model.getImg()).into(holder.imageView);
        holder.tvUser.setText(model.getName());
        holder.tvLike.setText(model.getId());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position Clicked="+position, Toast.LENGTH_SHORT).show();
            }
        });






    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class DataViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView tvUser;
        TextView tvLike;
        CardView cardView;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            tvUser=itemView.findViewById(R.id.tvUser);
            tvLike=itemView.findViewById(R.id.tvLike);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
