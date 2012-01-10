package org.upc.socrates.nota;

import java.util.List;

import org.upc.R;
import org.upc.socrates.model.Curso;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

@SuppressWarnings("rawtypes")
public class CursoAdapter extends ArrayAdapter {
	private Activity context;
	private List<Curso> cursos;

	@SuppressWarnings("unchecked")
	public CursoAdapter(Activity context, List<Curso> cursos) {
		super(context, R.layout.list_item_curso, cursos);
		this.context = context;
		this.cursos = cursos;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View item = inflater.inflate(R.layout.list_item_curso, null);

		TextView textView = (TextView) item.findViewById(R.id.codigoTextView);
		textView.setText(cursos.get(position).getCodigo());

		textView = (TextView) item.findViewById(R.id.nombreTextView);
		textView.setText(cursos.get(position).getNombre());

		textView = (TextView) item.findViewById(R.id.notaTextView);
		textView.setText(cursos.get(position).getNota());

		return item;
	}
}
