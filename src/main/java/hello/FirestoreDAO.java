package hello;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class FirestoreDAO {
	
	private CollectionReference collectionGreeting;

	public FirestoreDAO() {
		this.connect();
	}
	
	private void connect() {
		try {
			InputStream serviceAccount = new FileInputStream("aula-f607b-firebase-adminsdk-0cbot-9bb352d1fc.json");
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(credentials)
					.setProjectId("aula-f607b")
					.build();
			
			FirebaseApp.initializeApp(options);
			
			Firestore db = FirestoreClient.getFirestore();
			this.collectionGreeting = db.collection("greeting");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean save(Greeting obj) {
		try {
			DocumentReference doc = this.collectionGreeting.document(obj.getId()+"");
			doc.set(obj);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Greeting> getAll() {
		List<Greeting> lista = new ArrayList<>();
		
		try {
			List<QueryDocumentSnapshot> documents = this.collectionGreeting.get().get().getDocuments();
			
			for (QueryDocumentSnapshot doc: documents) {
				Greeting greeting = doc.toObject(Greeting.class);
				lista.add(greeting);
			}
			
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
