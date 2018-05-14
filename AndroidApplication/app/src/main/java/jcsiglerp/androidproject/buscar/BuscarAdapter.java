package jcsiglerp.androidproject.buscar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jcsiglerp.androidproject.Model.Prenda;
import jcsiglerp.androidproject.R;

public class BuscarAdapter extends RecyclerView.Adapter<BuscarAdapter.BuscarViewHolder> {

    public List<Prenda> data = new ArrayList<>();
    private AddToCartClickedListener listener;

    BuscarAdapter(AddToCartClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public BuscarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Vas a poner el xml de la vista por item R.layout.view_item_buscar
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_buscar, parent, false);
        return new BuscarViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(BuscarViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Prenda> newData) {
        this.data = data;
        notifyDataSetChanged();
    }

    interface AddToCartClickedListener {
        void itemClicked(Prenda prenda);
    }

    class BuscarViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView image;
        Prenda prenda;

        public BuscarViewHolder(View itemView, final AddToCartClickedListener lister) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            image = itemView.findViewById(R.id.ivPrenda);
            itemView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (prenda != null) {
                        lister.itemClicked(prenda);
                    }
                }
            });
        }

        void bind(Prenda prenda) {
            this.prenda = prenda;
            nombre.setText(prenda.nombre);
            // TODO AGREGAR URL
            Picasso.get().load("").placeholder(R.mipmap.ic_launcher).error(android.R.drawable.stat_notify_error).into(image);
        }
    }
}
