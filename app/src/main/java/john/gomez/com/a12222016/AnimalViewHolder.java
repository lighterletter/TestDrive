package john.gomez.com.a12222016;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private final View root;
    private TextView textView;

    public AnimalViewHolder(ViewGroup parent) {
        super(inflate(parent));
        root = itemView;
        textView = (TextView) root.findViewById(R.id.animal_name);
    }

    private static View inflate(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.item_row, parent, false);
    }


    public void bind(final Animal animal){

        textView.setText(animal.getName());

        try {
            textView.setTextColor(Color.parseColor(animal.getTextColor().toUpperCase()));
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackgroundColor(Color.parseColor(animal.getBackground().toUpperCase()));
                }
            });
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

}
