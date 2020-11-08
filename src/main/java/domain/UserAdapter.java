package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
public class UserAdapter extends AbstractTableModel{
	private String[] nombresColumnas = {"Event","Question", "Event Date", "Bet(€)"};
    private Object[][] data;
	public UserAdapter(User u) {
		Vector<Bet> vec= u.getApuestas();
		int longitud = vec.size();
		data= new Object[longitud][nombresColumnas.length];
		Iterator<Bet> vc = vec.iterator();
		int i =0;
		while (vc.hasNext()) {
			Bet v = vc.next();
			data[i][0]= v.getEventoAsociado();
			data[i][1]=v.getPreguntaAsociada();
			data[i][2]=v.getEventoAsociado().getEventDate();
			data[i][3]=v.getCantidad();
			i++;
		}
	}

	public int getColumnCount() { 
		return nombresColumnas.length;
	} 
	public String getColumnName(int col) {
		return nombresColumnas[col];
	}
	public int getRowCount() {
		return data.length;
	} 
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
}