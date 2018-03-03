package io.github.deepaksood619.khatriapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by deepak on 02/03/18.
 */

class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder> {
    private static final String TAG = DisplayAdapter.class.getSimpleName();

    private List<User> users;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvDisplayItem;
        public CardView cvItem;
        private final Context context;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            this.tvDisplayItem = view.findViewById(R.id.tv_display_item);
            this.cvItem = view.findViewById(R.id.cv_item);

        }
    }

    public DisplayAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvDisplayItem.setText(users.get(position).getName());
        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, DisplayItem.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user_object", users.get(position));
                intent.putExtras(bundle);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
