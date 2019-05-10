 

// Update this file with your own code.

public class Spreadsheet implements Grid
{
    Cell[][] cell = new Cell[20][12];
   
    public Spreadsheet(){
        for(int i = 0; i < getRows(); i++){
            for(int k = 0; k < getCols(); k++){
                cell[i][k] = new EmptyCell();
            }
        }
    }
            
    @Override
    public String processCommand(String command)
    {
        if(command.length() >= 2 && !command.toUpperCase().contains("CLEAR") && !command.contains("=")){
            SpreadsheetLocation loc = new SpreadsheetLocation(command); 
            return cell[loc.getRow()][loc.getCol()].fullCellText();
        }
        else if(command.toUpperCase().equals("CLEAR")){
            for(int i = 0; i < cell.length; i++){
                for(int j = 0; j < cell[0].length; j++){
                    cell[i][j] = new EmptyCell();
                }
            }
            return this.getGridText();
        }
        else if(command.toLowerCase().contains("clear") && command.length() >= 8 && !command.contains("=")){
            String clear = "clear ";
            SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(command.toLowerCase().indexOf(clear) + clear.length(), command.length()));
           
            cell[loc.getRow()][loc.getCol()] = new EmptyCell();
            return this.getGridText();
        }
        if(command.contains("=")){
        int equals = command.indexOf("=")+2;
        
            if(command.contains("\"")){
            SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" =")));
            
            String newVal = command.substring(equals);
            
            cell[loc.getRow()][loc.getCol()] = new TextCell(newVal);
            return this.getGridText();
            }
            if(command.contains("%")){
                SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" =")));
                
                String percent = command.substring(equals);
                
                cell[loc.getRow()][loc.getCol()] = new PercentCell(percent);
                return this.getGridText();
            }
            if(!command.contains(")") || !command.contains("(")){
                SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" =")));
                
                String value = command.substring(equals);
                
                cell[loc.getRow()][loc.getCol()] = new ValueCell(value);
                return this.getGridText();
            }
            if(command.contains("(") && command.contains(")")){
                SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" =")));
                
                String formula = command.substring(equals);
                
                cell[loc.getRow()][loc.getCol()] = new FormulaCell(formula, this);
                return this.getGridText();
            }
        }
        
            return "";
    }

    @Override
    public int getRows()
    {
        // TODO Auto-generated method stub
        return cell.length;
    }

    @Override
    public int getCols()
    {
        // TODO Auto-generated method stub
        return cell[0].length;
    }

    @Override
    public Cell getCell(Location loc)
    {
        return cell[loc.getRow()][loc.getCol()];
    }

    @Override
    public String getGridText()
    {
        
        String spreadSheet = "   |";
        for(int col = 0; col < getCols(); col++)
        {
            spreadSheet += ((char)(col + 65)) + "         |";
        }
        spreadSheet += '\n';
        for(int rows = 0; rows < getRows(); rows++){
            String indent = (rows + 1)+"";
            for(int space = indent.length(); space < 3; space++){
                indent += " ";
            }
            indent += "|";
            spreadSheet += indent;
            for(int col = 0; col < getCols(); col++){
                
                
                spreadSheet += cell[rows][col].abbreviatedCellText()+"|";
               
            }
            spreadSheet += '\n';
            
        }
        return spreadSheet;
   }
}


