package mvp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.event.dom.client.DragStartEvent;

import mvp.shared.Row;
import sk.turn.gwtmvp.client.HandlerView;
import sk.turn.gwtmvp.client.HtmlElement;
import sk.turn.gwtmvp.client.HtmlHandler;
import sk.turn.gwtmvp.client.adapters.ViewAdapter;

class RowAdapter extends ViewAdapter<Row, RowAdapter.RowView > {
	  interface RowView extends HandlerView<TableElement, RowAdapter> {
		  @HtmlElement TableElement getRow();
	 }
	 
	 public RowAdapter(Element parentElement) {
	    super(parentElement);
	 }
	 
	  @Override
	  protected RowView createView() {
		RowView view = GWT.create(RowView.class);
	    view.setHandler(this);
	    return view;
	  }
	  
	  @Override
	  	protected void setViewData(RowView view, Row item) { 
	  }
	  
	  @HtmlHandler("row")
	  void onDragStart(DragStartEvent event) {
		  GWT.log("Before changed color");
		  int index = getItemIndexFromEvent(event);
		 // view.getRow().getStyle().setBackgroundColor("#41afbf");
	  }
}