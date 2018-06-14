package mvp.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.TableSectionElement;

import mvp.shared.Row;
import sk.turn.gwtmvp.client.BasePresenter;
import sk.turn.gwtmvp.client.HandlerView;
import sk.turn.gwtmvp.client.HtmlElement;

public class HelloPresenter extends BasePresenter<HelloPresenter.HelloView> {

  interface HelloView extends HandlerView<DivElement, HelloPresenter> {
	 
	  @HtmlElement TableSectionElement getRowContainer();
  }

  private RowAdapter adapter;
  List<Row> rows = new ArrayList<>();
  
  public HelloPresenter() {
    super("", GWT.<HelloView>create(HelloView.class));
    view.setHandler(this);
  }
  
  @Override
  public void onViewLoaded() {
    adapter = new RowAdapter(getView().getRowContainer());
   
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    rows.add(new Row());
    
    
    adapter.setItems(rows);
  }

  
  
  
 
  
}