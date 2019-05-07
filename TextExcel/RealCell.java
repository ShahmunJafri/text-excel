
/**
 * Write a description of class RealCell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RealCell implements Cell
{
    // instance variables - replace the example below with your own
    private String input;

    /**
     * Constructor for objects of class RealCell
     */
    public RealCell(String input)
    {
        this.input = input;
        
    }

    public String abbreviatedCellText(){
        return null;
    }// text for spreadsheet cell display, must be exactly length 10
    public String fullCellText(){
       return input; 
    }
}
