
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
    private double x;
    /**
     * Constructor for objects of class ValueCell
     */
    public ValueCell(String input)
    {
         super(input);
         this.input = input;
         x = Double.parseDouble(input);
    }

    public String abbreviatedCellText(){
        String y = x + "";
        if(y.length() > 10){
            return y.substring(0, 10);
        }
        String space = "";
        for(int i = y.length(); i < 10; i++){
            space += " ";
        }
        return y + space;
    }// text for spreadsheet cell display, must be exactly length 10
    public String fullCellText(){
       return input; 
    }
    public double getDoubleValue(){
        return x;
    }
}
