package mvp.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.TableElement;

import mvp.shared.Row;
import sk.turn.gwtmvp.client.BasePresenter;
import sk.turn.gwtmvp.client.HandlerView;
import sk.turn.gwtmvp.client.HtmlElement;

public class HelloPresenter extends BasePresenter<HelloPresenter.HelloView> {

  interface HelloView extends HandlerView<DivElement, HelloPresenter> {
	 
	  @HtmlElement TableElement getRowContainer();
  }

  private RowAdapter adapter;
  
  public HelloPresenter() {
    super("", GWT.<HelloView>create(HelloView.class));
    view.setHandler(this);
  }
  
  @Override
  public void onViewLoaded() {
    adapter = new RowAdapter(getView().getRowContainer());
  }
  @Override
  public void onShow(String... groups) {
    List<Row> rows = new ArrayList<>();
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    // Load the person list
    adapter.setItems(rows);
  }
  
  
  
 
  
}