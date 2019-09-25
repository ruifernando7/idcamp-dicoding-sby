package com.example.javakotlin.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javakotlin.R;
import com.example.javakotlin.data.remote.model.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamRvAdapter extends RecyclerView.Adapter<TeamRvAdapter.ViewHolder> {
    private List<Team> listTeam;
    private RvListener listener;

    public TeamRvAdapter(List<Team> teams, RvListener listener){
        this.listTeam = teams;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TeamRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvrow_team,parent,false);
        return new TeamRvAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamRvAdapter.ViewHolder holder, int position) {
        holder.bind(listTeam.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return listTeam.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView teamLogo;
        private TextView teamName;

        public ViewHolder(View v){
            super(v);
            teamLogo = v.findViewById(R.id.iv_rvteam_logo);
            teamName = v.findViewById(R.id.tv_rvteam_name);
        }

        void bind(final Team item, final RvListener listener) {
            Picasso.get().load(item.getStrTeamBadge()).into(teamLogo);
            teamName.setText(item.getStrTeam());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public interface RvListener {
        void onItemClick(Team team);
    }
}


