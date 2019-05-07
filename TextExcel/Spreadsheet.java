 

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
        else if(command.toLowerCase().contains("clear") && command.length() >= 8){
            String clear = "clear ";
            SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(command.toLowerCase().indexOf(clear) + clear.length(), command.length()));
            cell[loc.getRow()][loc.getCol()] = new EmptyCell();
            return this.getGridText();
        }
        else if(command.contains("\"")){
            SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" ="))); 
            String newVal = command.substring(command.indexOf("= ") + 2, command.length());
            cell[loc.getRow()][loc.getCol()] = new TextCell(newVal);
            return this.getGridText();
        }
        else if(!command.contains("\"") && ((command.contains(".") || command.contains("%") || (command.contains(")") && command.contains("("))))){
            SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(0, command.indexOf(" =")));
            
            if(command.contains("%")){
                cell[loc.getRow()][loc.getCol()] = new PercentCell(command.substring(command.indexOf("= " + 2, command.length())));
            }
            else if(command.contains(".")){
                cell[loc.getRow()][loc.getCol()] = new ValueCell(command.substring(command.indexOf("= " + 2, command.length())));
            }
            else if(command.contains("(") && command.contains(")")){
                cell[loc.getRow()][loc.getCol()] = new FormulaCell(command.substring(command.indexOf("= " + 2, command.length())));
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
        
        String spreadSheet = "     |";
        for(int col = 0; col < getCols(); col++)
        {
            spreadSheet += ((char)(col + 65)) + "         |";
        }
        spreadSheet += '\n';
        for(int rows = 0; rows < getRows(); rows++){
            String indent = (rows + 1)+"";
            for(int space = indent.length(); space < 5; space++){
                indent += " ";
            }
            indent += "|";
            spreadSheet += indent;
            for(int col = 0; col < getCols(); col++){
                String space = "";
                if(cell[rows][col].abbreviatedCellText().length() < 10){
                   for(int i = cell[rows][col].abbreviatedCellText().length(); i < 10; i++){
                       space += " ";
                    }
                }
                
                spreadSheet += cell[rows][col].abbreviatedCellText()+ space + "|" + "";
               
            }
            spreadSheet += '\n';
            
        }
        return spreadSheet;
   }
}


