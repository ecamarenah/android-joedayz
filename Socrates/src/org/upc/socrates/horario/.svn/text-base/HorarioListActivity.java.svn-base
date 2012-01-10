package org.upc.socrates.horario;

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
import org.upc.socrates.model.Hora;
import org.upc.socrates.model.HoraList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class HorarioListActivity extends AbstractAsyncListActivity {
	private class DownloadStatesTask extends AsyncTask<Void, Void, List<Hora>> {
		private int tab;

		@Override
		protected void onPreExecute() {
			// before the network request begins, show a progress indicator
			showLoadingProgressDialog();

			Bundle extras = getIntent().getExtras();
			tab = extras.getInt("tab");
		}

		@Override
		protected List<Hora> doInBackground(Void... params) {
			try {
				// The URL for making the GET request
				final String url = getString(R.string.base_uri) + "/horas/{tab}";

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
				ResponseEntity<HoraList> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, HoraList.class, tab);

				// Return the list
				HoraList horaList = responseEntity.getBody();
				return horaList.getHoras();
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
			}

			return null;
		}

		@Override
		protected void onPostExecute(List<Hora> result) {
			// hide the progress indicator when the network request is complete
			dismissProgressDialog();

			// returna el resultado
			refresh(result);
		}
	}

	protected static final String TAG = HorarioListActivity.class.getSimpleName();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		theme.onActivityCreateSetTheme(this);
	}

	@Override
	public void onStart() {
		super.onStart();

		// when this activity starts, initiate an asynchronous HTTP GET request
		new DownloadStatesTask().execute();
	}

	private void refresh(List<Hora> horas) {
		if (horas == null) {
			Toast.makeText(this, "No hay clases programadas para este día.", Toast.LENGTH_LONG).show();
			return;
		}

		setListAdapter(new HorarioAdapter(this, horas));
	}
}
