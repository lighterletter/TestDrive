package john.gomez.com.a12222016;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    List<Animal> animals;

    public AnimalAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        holder.bind(animals.get(position));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
