package com.example.implementasiapi10pplg1_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private Context context;
    private List<Team> teamList;

    public TeamAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamName.setText(team.getStrTeam());
        holder.stadium.setText(team.getStrStadium());
        Glide.with(context)
                .load(team.getStrBadge())
                .into(holder.teamLogo);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName, stadium;
        ImageView teamLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.teamName);
            stadium = itemView.findViewById(R.id.stadium);
            teamLogo = itemView.findViewById(R.id.teamLogo);
        }
    }
}