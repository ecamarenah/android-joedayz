package org.upc.socrates.horario;

import java.util.List;

import org.upc.R;
import org.upc.socrates.MapsActivity;
import org.upc.socrates.model.Hora;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("rawtypes")
public class HorarioAdapter extends ArrayAdapter {
	private Activity context;
	private List<Hora> horas;

	@SuppressWarnings("unchecked")
	public HorarioAdapter(Activity context, List<Hora> horas) {
		super(context, R.layout.list_item_hora, horas);
		this.context = context;
		this.horas = horas;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View item = inflater.inflate(R.layout.list_item_hora, null);

		TextView textView = (TextView) item.findViewById(R.id.horaTextView);
		textView.setText(horas.get(position).getHora());

		textView = (TextView) item.findViewById(R.id.cursoTextView);
		textView.setText(horas.get(position).getCurso());

		textView = (TextView) item.findViewById(R.id.aulaTextView);
		textView.setText(horas.get(position).getAula());

		textView = (TextView) item.findViewById(R.id.seccionTextView);
		textView.setText(horas.get(position).getSeccion());

		Button button = (Button) item.findViewById(R.id.localButton);
		button.setText(horas.get(position).getLocal());
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(context, MapsActivity.class);
				context.startActivity(intent);
			}
		});

		return item;
	}
}
