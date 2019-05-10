
/**
 * Write a description of class FormulaCell here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FormulaCell extends RealCell implements Cell
{
    // instance variables - replace the example below with your own
    private String input;
    private Spreadsheet spreadsheet;
    /**
     * Constructor for objects of class FormulaCell
     */
    public FormulaCell(String input, Spreadsheet thisOne)
    {
        super(input);
        this.input = input;
        this.spreadsheet = thisOne;
    }

   public String abbreviatedCellText(){
        String x = getDoubleValue() + "";
        
        if(x.length() > 10){
            return x.substring(0, 10);
        }
        
        String space = "";
        for(int i = x.length(); i < 10; i++){
            space += " ";
        }
        return x + space;
    }// text for spreadsheet cell display, must be exactly length 10
    public String fullCellText(){
       return input; 
    }
    public boolean containsLetter(String number){
        if(number.toLowerCase().contains("a")||number.toLowerCase().contains("b")||number.toLowerCase().contains("c")
        ||number.toLowerCase().contains("d")||number.toLowerCase().contains("e")||number.toLowerCase().contains("f")
        ||number.toLowerCase().contains("g")||number.toLowerCase().contains("h")||number.toLowerCase().contains("i")
        ||number.toLowerCase().contains("j")||number.toLowerCase().contains("k")||number.toLowerCase().contains("l")){
            return true;
        }
        return false;
    }
    public double getDoubleValue(){
           String[] numbers = input.split(" ");
           double value = 0.0;
           
           
            if(!input.toLowerCase().contains("sum") && !input.toLowerCase().contains("avg")){
          
               if(!containsLetter(numbers[1])){
                   value += Double.parseDouble(numbers[1]); 
                }
                else{
                SpreadsheetLocation locFirst = new SpreadsheetLocation(numbers[1]);
                
                   value += ((RealCell)spreadsheet.getCell(locFirst)).getDoubleValue();
                 }
                
        
                for(int i = 2; i < numbers.length-1; i+=2){
                    if(numbers[i].equals("+")){
                        if(!containsLetter(numbers[i+1])){
                            value += Double.parseDouble(numbers[i+1]);
                        }
                             else{
                            SpreadsheetLocation locValue = new SpreadsheetLocation(numbers[i+1]);
                  
                                 value += ((RealCell)spreadsheet.getCell(locValue)).getDoubleValue();
                    }
                }
            
              if(numbers[i].equals("-")){
               
               if(!containsLetter(numbers[i+1])){
                value -= Double.parseDouble(numbers[i+1]);
              }
               else{
                   SpreadsheetLocation locValue = new SpreadsheetLocation(numbers[i+1]);
                   
                   value -= ((RealCell)spreadsheet.getCell(locValue)).getDoubleValue();
                 }
               }
              if(numbers[i].equals("/")){
                
                if(!containsLetter(numbers[i+1])){
                value /= Double.parseDouble(numbers[i+1]);
              }
               else{
                   SpreadsheetLocation locValue = new SpreadsheetLocation(numbers[i+1]);
                   
                   value -= ((RealCell)spreadsheet.getCell(locValue)).getDoubleValue();
                 }
               }
              if(numbers[i].equals("*")){
                
                if(!containsLetter(numbers[i+1])){
                value *= Double.parseDouble(numbers[i+1]);
              }
               else{
                   SpreadsheetLocation locValue = new SpreadsheetLocation(numbers[i+1]);
                  
                   value *= ((RealCell)spreadsheet.getCell(locValue)).getDoubleValue();
                 }
               }
              
            
             }
             return value; 
            }
                
            else{
               if(input.toLowerCase().contains("sum")){
                 
                String last = numbers[2].substring(numbers[2].indexOf("-")+1);
                String first = numbers[2].substring(0,numbers[2].indexOf("-"));
                SpreadsheetLocation loc = new SpreadsheetLocation(first.toUpperCase());
                SpreadsheetLocation loc2 = new SpreadsheetLocation(last.toUpperCase());
                double sum;
                 
                   sum = ((RealCell)spreadsheet.getCell(loc)).getDoubleValue();
                 
                for(int i = loc.getRow(); i <= loc2.getRow(); i++){
                    for(int k = loc.getCol(); k <= loc2.getCol(); k++){
                        String col = (char)(k+65) +"";
                        int row = i;
                      SpreadsheetLocation loc3 = new SpreadsheetLocation(col+row);
                        
                        sum += ((RealCell)spreadsheet.getCell(loc3)).getDoubleValue();
                      }
                    }
                    return sum;
                }
                
            
            
            
            
            
             else if(input.toLowerCase().contains("avg")){
                  String first = numbers[2].substring(0,numbers[2].indexOf("-"));
                  String second = numbers[2].substring(numbers[2].indexOf("-")+1);
                  SpreadsheetLocation loc = new SpreadsheetLocation(first);
                  SpreadsheetLocation loc2 = new SpreadsheetLocation(second);
                  double sum;
                  int avg = 0;
                  
                  sum = ((RealCell)spreadsheet.getCell(loc)).getDoubleValue();
                
                 
                for(int i = loc.getRow(); i < loc2.getRow(); i++){
                    for(int k = loc.getCol(); k < loc2.getCol(); k++){
                      SpreadsheetLocation loc3 = new SpreadsheetLocation((char)k + "" + (i));
                        
                        sum += ((RealCell)spreadsheet.getCell(loc3)).getDoubleValue();
                        avg++;
                       }

                      }
                      return sum/avg;
                    }
                }
                  return value; 
                }
            
                
            }
           
            
            
        
             
             
             
       
        
           
            
         
         
         
            
         
    


