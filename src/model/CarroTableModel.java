


package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class CarroTableModel extends AbstractTableModel{
    
    private List<Carro> dados = new ArrayList<>();             
    private String[] colunas = {"Marca","Modelo","Ano"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
        
    @Override
    public int getRowCount() {
        return dados.size();
     
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
       
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getMarca();
            case 1:
                return dados.get(linha).getMod();
            case 2:
                return dados.get(linha).getAno();
                        
           
            
        }
        
        return null;
        
        
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
        switch(coluna){
            case 0:
                dados.get(linha).setMarca((String) valor);
                break;
            case 1:
                dados.get(linha).setMod((String) valor);
                break;
            case 2:
                dados.get(linha).setAno(Integer.parseInt((String) valor));
                break;       
        }
        
        this.fireTableRowsUpdated(linha, linha);
        
    }
    
    
    
    public void addRow(Carro c){
        this.dados.add(c);
        this.fireTableDataChanged();  
        
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        
    }
    
    
    
}
