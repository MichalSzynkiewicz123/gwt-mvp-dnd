package mvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;

import sk.turn.gwtmvp.client.Mvp;


public class Mvp_dnd implements EntryPoint {
	
	
	public void onModuleLoad() {
		 Mvp mvp = new Mvp(Document.get().getElementById("container"));
		 mvp.addPresenter(new HelloPresenter());
		 mvp.start();
	}
}
