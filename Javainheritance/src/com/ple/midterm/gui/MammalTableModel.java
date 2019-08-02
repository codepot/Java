package com.ple.midterm.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.ple.midterm.Mammal;

public class MammalTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Mammal> lists;

    public MammalTableModel(List<Mammal> lists) {
        this.lists = lists;
    }

    @Override
    public int getRowCount() {
        return lists.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "ID";
                break;
            case 1:
                name = "INSTANCE OF";
                break; 
            case 2:
                name = "NAME";
                break;
            case 3:
                name = "TYPE";
                break;
            case 4:
                name = "AGE";
                break;
            case 5:
                name = "FOOD CATEGORY";
                break;
            case 6:
                name = "CAGE CLEAN FREQ";
                break;
            case 7:
                name = "CAGE LAST CLEANED DATE";
                break;
            case 8:
                name = "TO CLEAN CAGE?";
                break;  
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // NOT EDITABLE
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mammal mammal = lists.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = "" + mammal.getId();
                break;
            case 1:
                value = "" + mammal.getClass().getSimpleName();
                break;
            case 2:
                value = mammal.getName();
                break;
            case 3:
                value = mammal.getType();
                break;
            case 4:
                value = mammal.getAge()+ "";
                break;
            case 5:
                value = mammal.getFoodCategory();
                break;
            case 6:
                value = mammal.getCageCleanedFrequency();
                break;
            case 7:
                value = mammal.getFormatedCageLastCleanedDate();
                break;
            case 8:
                value = (mammal.needCageCleaning())? "YES" : "-";
                break;
        }
        return value;
    }            
}
