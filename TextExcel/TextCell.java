
/**
 * Write a description of class TextCell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextCell implements Cell
{
    private String text;
    public TextCell(String text)
    {
        this.text = text;
        
    }

    public String abbreviatedCellText(){
        if(text.length() > 10){
            return text.substring(0, 9) + "\"";
        }
       
        return text;
    }// text for spreadsheet cell display, must be exactly length 10
    public String fullCellText(){
       return text; 
    }
}
