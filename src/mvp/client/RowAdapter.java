package mvp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.TableColElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DropEvent;

import mvp.shared.Row;
import sk.turn.gwtmvp.client.HandlerView;
import sk.turn.gwtmvp.client.HtmlElement;
import sk.turn.gwtmvp.client.HtmlHandler;
import sk.turn.gwtmvp.client.adapters.ViewAdapter;

class RowAdapter extends ViewAdapter<Row, RowAdapter.RowView > {
	  interface RowView extends HandlerView<TableRowElement, RowAdapter> {
		  @HtmlElement TableRowElement getRow();
		  @HtmlElement TableColElement getCol();
		  @HtmlElement TableColElement getCol1();
		  @HtmlElement TableColElement getCol2();
	 }
	 
	 public RowAdapter(TableSectionElement parentElement) {
	    super(parentElement);
	 }
	 
	  @Override
	  protected RowView createView() {
		RowView view = GWT.create(RowView.class);
	    view.setHandler(this);
	    return view;
	  }
	  
	  int i = 0;
	  
	  @Override
	  	protected void setViewData(RowView view, Row item) {
		  i++;
		  view.getCol().setInnerHTML("Example" + i);
		  view.getCol1().setInnerHTML("Example" + i);
		  view.getCol2().setInnerHTML("Example" + i);
	  }
	  
	  
	  Row drag;
	  Row over;
	  
	  String htmlDrag, htmlOver;
	  RowView dragged;
	  
	  
	  @HtmlHandler("row")
	  void onDragStart(DragStartEvent event) {
		  int index = getItemIndexFromEvent(event);
		  //getting data from item
		  drag = getItem(index);
		  //getting html data
		  htmlDrag = getItemView(index).getRow().getInnerHTML();
		  dragged = getItemView(index);
	  }
	  
	  @HtmlHandler("row")
	  void onDragOver(DragOverEvent event) {
		  int index = getItemIndexFromEvent(event);
		  GWT.log(""+ index);
		  //getting the data from item
		  over = getItem(index);
		  //getting html data
		  GWT.log(getItemView(index).getRow().getInnerHTML());
		  htmlOver = getItemView(index).getRow().getInnerHTML();
	  }
	  
	  @HtmlHandler("row")
	  void onDragEnter(DragEnterEvent event) {
	  }
	  
	  @HtmlHandler("row")
	  void onDragLeave(DragLeaveEvent event) {
	  }
	  
	  @HtmlHandler("row")
	  void onDrop(DropEvent event) {
		  int index = getItemIndexFromEvent(event);
		  // Replacing html
		  getItemView(index).getRow().setInnerHTML(htmlDrag);
		  dragged.getRow().setInnerHTML(htmlOver);
		  
	  }
}