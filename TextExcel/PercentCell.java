
/**
 * Write a description of class PercentCell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PercentCell extends RealCell implements Cell 
{
    // instance variables - replace the example below with your own
    private String input;

    /**
     * Constructor for objects of class PercentCell
     */
    public PercentCell(String input)
    {
        super(input);
        
    }

    public String abbreviatedCellText(){
        return null;
    }// text for spreadsheet cell display, must be exactly length 10
    public String fullCellText(){
       return input; 
    }
}
