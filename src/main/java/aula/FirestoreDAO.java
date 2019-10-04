package aula;

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

import aula.gerente.Funcionario;
import aula.hello.Greeting;

public class FirestoreDAO {
	
	private CollectionReference collectionGreeting;
	private CollectionReference collectionFuncionario;

	public FirestoreDAO() {
		this.connect();
	}
	
	private void connect() {
		try {
			InputStream serviceAccount = new FileInputStream("config-file-firebase-adminsdk.json");
			GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(credentials)
					.setProjectId("aula-f607b")
					.build();
			
			FirebaseApp.initializeApp(options);
			
			Firestore db = FirestoreClient.getFirestore();
			this.collectionGreeting = db.collection("greeting");
			this.collectionFuncionario = db.collection("funcionario");
			
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
	
	public boolean save(Funcionario f) {
		try {
			DocumentReference doc = this.collectionFuncionario.document(f.getEmail());
			doc.set(f);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(String email) {
		try {
			this.collectionFuncionario.document(email).delete();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Funcionario> getFuncionarios() {
		List<Funcionario> lista = new ArrayList<>();
		
		try {
			List<QueryDocumentSnapshot> documents = this.collectionFuncionario.get().get().getDocuments();
			
			for (QueryDocumentSnapshot doc: documents) {
				Funcionario funcionario = doc.toObject(Funcionario.class);
				lista.add(funcionario);
			}
			
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
