package mvp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.event.dom.client.DragStartEvent;

import sk.turn.gwtmvp.client.BasePresenter;
import sk.turn.gwtmvp.client.HandlerView;
import sk.turn.gwtmvp.client.HtmlElement;
import sk.turn.gwtmvp.client.HtmlHandler;

public class HelloPresenter extends BasePresenter<HelloPresenter.HelloView> {

  interface HelloView extends HandlerView<DivElement, HelloPresenter> {
	  @HtmlElement TableElement getRow();
  }

  public HelloPresenter() {
    super("", GWT.<HelloView>create(HelloView.class));
    view.setHandler(this);
  }
  
  @HtmlHandler("row")
  void onDragStart(DragStartEvent event) {
	  GWT.log("Before changed color");
	  view.getRow().getStyle().setBackgroundColor("#41afbf");
  }
  
}