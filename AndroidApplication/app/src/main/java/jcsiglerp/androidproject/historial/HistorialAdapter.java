package jcsiglerp.androidproject.historial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import jcsiglerp.androidproject.Model.Pedido;
import jcsiglerp.androidproject.R;

public class HistorialAdapter extends RecyclerView.Adapter <HistorialAdapter.HistorialViewHolder> {

    public List<Pedido> data = new ArrayList<>();
    private viewOnClickPedidoListener listener;

    HistorialAdapter(viewOnClickPedidoListener listener) {
        this.listener = listener;
    }

    @Override
    public HistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_historial, parent, false);
        return new HistorialViewHolder(viewItem, listener);
    }

    @Override
    public void onBindViewHolder(HistorialViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List < Pedido > data) {
        this.data = data;
        notifyDataSetChanged();
    }

    interface viewOnClickPedidoListener {
        void itemClicked(Pedido pedido);
    }

    class HistorialViewHolder extends RecyclerView.ViewHolder {

        Pedido pedido;
        TextView tvFecha, tvCantidad;

        public HistorialViewHolder(View itemView, final viewOnClickPedidoListener listener) {
            super(itemView);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvCantidad = itemView.findViewById(R.id.tvCantidad);
            itemView.findViewById(R.id.btPedido).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(pedido != null) {
                        listener.itemClicked(pedido);
                    }
                }
            });
        }

        public void bind(Pedido pedido) {
            this.pedido = pedido;
            tvFecha.setText("Fecha de compra:\n" + pedido.fecha.toString());
            tvCantidad.setText("Cantidad:\n$" + pedido.cantidad.toString());
        }
    }
}
