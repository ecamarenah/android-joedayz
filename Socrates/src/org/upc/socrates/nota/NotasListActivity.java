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
import org.upc.socrates.model.Nota;
import org.upc.socrates.model.NotaList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class NotasListActivity extends AbstractAsyncListActivity {
	private class DownloadStatesTask extends AsyncTask<Void, Void, List<Nota>> {
		@Override
		protected void onPreExecute() {
			// before the network request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected List<Nota> doInBackground(Void... params) {
			try {
				// The URL for making the GET request
				final String url = getString(R.string.base_uri) + "/notas";

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
				ResponseEntity<NotaList> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, NotaList.class);

				// Return the list
				NotaList notaList = responseEntity.getBody();
				return notaList.getNotas();
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
			}

			return null;
		}

		@Override
		protected void onPostExecute(List<Nota> result) {
			// hide the progress indicator when the network request is complete
			dismissProgressDialog();

			// returna el resultado
			refresh(result);
		}
	}

	protected static final String TAG = NotasListActivity.class.getSimpleName();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);

		View header = getLayoutInflater().inflate(R.layout.list_header_nota, null);
		getListView().addHeaderView(header);
	}

	@Override
	public void onStart() {
		super.onStart();

		// when this activity starts, initiate an asynchronous HTTP GET request
		new DownloadStatesTask().execute();
	}

	private void refresh(List<Nota> notas) {
		if (notas == null) {
			Toast.makeText(this, "No hay notas registradas.", Toast.LENGTH_LONG).show();
			return;
		}

		setListAdapter(new NotaAdapter(this, notas));
	}
}
