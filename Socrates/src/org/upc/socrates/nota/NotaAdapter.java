package org.upc.socrates.nota;

import java.util.List;

import org.upc.R;
import org.upc.socrates.model.Nota;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressWarnings("rawtypes")
public class NotaAdapter extends ArrayAdapter {
	private Activity context;
	private List<Nota> notas;

	@SuppressWarnings("unchecked")
	public NotaAdapter(Activity context, List<Nota> notas) {
		super(context, R.layout.list_item_nota, notas);
		this.context = context;
		this.notas = notas;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View item = inflater.inflate(R.layout.list_item_nota, null);

		TextView textView = (TextView) item.findViewById(R.id.evaluacionTextView);
		textView.setText(notas.get(position).getEvaluacion());

		textView = (TextView) item.findViewById(R.id.pesoTextView);
		textView.setText(notas.get(position).getPeso());

		textView = (TextView) item.findViewById(R.id.valorTextView);
		textView.setText(notas.get(position).getValor());

		return item;
	}
}
