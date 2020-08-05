package ipelx.com.youtubemvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {

    private Context context;
    private ArrayList<MovieModel> movieModels;
    private LayoutInflater inflater;

    public MovieAdapter(Context context, ArrayList<MovieModel> movieModels) {
        this.context = context;
        this.movieModels = movieModels;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.custom,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txt.setText(movieModels.get(holder.getAdapterPosition()).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView txt;
        public Holder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
