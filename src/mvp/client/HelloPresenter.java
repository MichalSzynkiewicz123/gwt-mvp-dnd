package mvp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;

import sk.turn.gwtmvp.client.BasePresenter;
import sk.turn.gwtmvp.client.HandlerView;

public class HelloPresenter extends BasePresenter<HelloPresenter.HelloView> {

	  interface HelloView extends HandlerView<DivElement, HelloPresenter> {
	  }


	  public HelloPresenter() {
	    super("", GWT.<HelloView>create(HelloView.class));
	    view.setHandler(this);
	  }
}