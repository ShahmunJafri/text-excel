 

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
   
    int column;
    int row;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        
        this.column = cellName.toUpperCase().charAt(0) - 65;
        this.row = Integer.parseInt(cellName.substring(1))-1;
        // TODO: Fill this out with your own code
    }

}
