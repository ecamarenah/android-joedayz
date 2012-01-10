package org.upc.socrates.nota;

import static org.upc.socrates.MainActivity.theme;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.upc.R;
import org.upc.socrates.AbstractAsyncListActivity;
import org.upc.socrates.model.Curso;
import org.upc.socrates.model.CursoList;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class CursosListActivity extends AbstractAsyncListActivity {
	private class DownloadStatesTask extends AsyncTask<Void, Void, List<Curso>> {
		@Override
		protected void onPreExecute() {
			// before the network request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected List<Curso> doInBackground(Void... params) {
			try {
				// The URL for making the GET request
				final String url = getString(R.string.base_uri) + "/cursos";

				// Set the Accept header for "application/xml"
				HttpHeaders requestHeaders = new HttpHeaders();
				List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
				acceptableMediaTypes.add(MediaType.APPLICATION_XML);
				requestHeaders.setAccept(acceptableMediaTypes);

				// Populate the headers in an HttpEntity object to use for the
				// request
				HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

				// Create a new RestTemplate instance
				RestTemplate restTemplate = new RestTemplate();

				// Perform the HTTP GET request
				ResponseEntity<CursoList> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, CursoList.class);

				// Return the list
				CursoList cursoList = responseEntity.getBody();
				return cursoList.getCursos();
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
			}

			return null;
		}

		@Override
		protected void onPostExecute(List<Curso> result) {
			// hide the progress indicator when the network request is complete
			dismissProgressDialog();

			// returna el resultado
			refresh(result);
		}
	}

	protected static final String TAG = CursosListActivity.class.getSimpleName();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);

		View header = getLayoutInflater().inflate(R.layout.list_header_curso, null);
		getListView().addHeaderView(header);
	}

	@Override
	public void onStart() {
		super.onStart();

		// when this activity starts, initiate an asynchronous HTTP GET request
		new DownloadStatesTask().execute();
	}

	private void refresh(List<Curso> cursos) {
		if (cursos == null) {
			Toast.makeText(this, "No hay cursos registrados.", Toast.LENGTH_LONG).show();
			return;
		}

		setListAdapter(new CursoAdapter(this, cursos));
	}

	@Override
	protected void onListItemClick(ListView parent, View view, int position, long id) {
		super.onListItemClick(parent, view, position, id);

		Intent intent = new Intent(CursosListActivity.this, NotasListActivity.class);
		startActivity(intent);
	}
}
