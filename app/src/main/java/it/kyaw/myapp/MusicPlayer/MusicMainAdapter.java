package it.kyaw.myapp.MusicPlayer;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import it.kyaw.myapp.Adapter.AppClickListener;
import it.kyaw.myapp.databinding.ItemAppBinding;


public class MusicMainAdapter extends RecyclerView.Adapter<MusicMainAdapter.MainViewHolder> {

    List<ArtistData> ArtistDataes;
    AppClickListener appClickListener;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var binding = ItemAppBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        ArtistData artistData = ArtistDataes.get(position);
        holder.bind(artistData);

        holder.binding.getRoot().setOnClickListener(v -> {
            appClickListener.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return ArtistDataes.size();
    }

    public void setAppDatas(List<ArtistData> appDatas) {
        this.ArtistDataes = appDatas;
        notifyDataSetChanged();
    }

    public void setAppClickListener(AppClickListener appClickListener) {
        this.appClickListener = appClickListener;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ItemAppBinding binding;

        public MainViewHolder(ItemAppBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ArtistData artistData) {
            binding.ivAppImage.setImageResource(artistData.img());
            binding.tvAppName.setText(artistData.name());
        }
    }
}
