
/**
 * Write a description of class ValueCell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ValueCell extends RealCell implements Cell
{
    // instance variables - replace the example below with your own
    private String input;

    /**
     * Constructor for objects of class ValueCell
     */
    public ValueCell(String input)
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
