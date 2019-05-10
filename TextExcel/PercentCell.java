
/**
 * Write a description of class PercentCell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PercentCell extends RealCell implements Cell 
{
    // instance variables - replace the example below with your own https://www.youtube.com/watch?v=2Gpl99s02Aw
    private String input;
    private int x;
    /**
     * Constructor for objects of class PercentCell
     */
    public PercentCell(String input)
    {
        super(input);
        this.input = input;
        this.x = Integer.parseInt(input.substring(0, input.indexOf(".")));
        
    }

    public String abbreviatedCellText(){
        
        String y = x + "%";
        if(y.length()>10){
            return y.substring(0, 10);
        }
        String space = "";
        for(int i = y.length(); i<10; i++){
            space += " ";
        }
        return y + space;
    }// text for spreadsheet cell display, must be exactly length 10
    public String fullCellText(){
       Double inputValue = Double.parseDouble(input.substring(0, input.indexOf("%")));
       return inputValue/100.0 +"";
    }
    public double getDoubleValue(){
        return Double.parseDouble(input.substring(0, input.indexOf("%")));
    }
}
