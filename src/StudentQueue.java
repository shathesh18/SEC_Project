import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class StudentQueue extends AbstractListModel {


//	private LinkedList<ListDataListener> listeners;
	ArrayList<String> list;

	public StudentQueue() {
		list=new ArrayList<String>();
		list.add("Gerrard");
		list.add("Torres");
	//    listeners = new LinkedList<ListDataListener>();
	}
	
	public void addData(String item) {
	    list.add(item);
	    fireIntervalAdded(item, getSize() - 1, getSize());
	  }
	
	  
	  public void removeData(int i) {
	    String victim = list.remove(i);
	    fireIntervalRemoved(victim, i, i+1);
	  }
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getElementAt(int index) {
		return list.get(index);
	}

//	@Override
/*	public void addListDataListener(ListDataListener l) {
		listeners.add(l);
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		listeners.remove(l);
		
	}*/
	
}
