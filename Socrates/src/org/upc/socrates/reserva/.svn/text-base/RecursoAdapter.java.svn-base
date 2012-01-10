package org.upc.socrates.reserva;

import java.util.List;

import org.upc.R;
import org.upc.socrates.model.Recurso;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressWarnings("rawtypes")
public class RecursoAdapter extends ArrayAdapter {
	private Activity context;
	private List<Recurso> recursos;

	@SuppressWarnings("unchecked")
	public RecursoAdapter(Activity context, List<Recurso> recursos) {
		super(context, R.layout.list_item_recurso, recursos);
		this.context = context;
		this.recursos = recursos;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View item = inflater.inflate(R.layout.list_item_recurso, null);

		TextView textView = (TextView) item.findViewById(R.id.codigoTextView);
		textView.setText(recursos.get(position).getCodigo());

		textView = (TextView) item.findViewById(R.id.descripcionTextView);
		textView.setText(recursos.get(position).getDescripcion());

		textView = (TextView) item.findViewById(R.id.localTextView);
		textView.setText(recursos.get(position).getLocal());

		textView = (TextView) item.findViewById(R.id.reservadoTextView);
		textView.setText(recursos.get(position).getReservado());

		return item;
	}
}
