
/**
 * Write a description of class TesterOfGetGrid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TesterOfGetGrid
{
  public static void main(String[]args){
      String[] numbers = {"(", "sum", "a1-a4"}; 
      String first = numbers[2].substring(0,numbers[2].indexOf("-"));
                  String second = numbers[2].substring(numbers[2].indexOf("-"));
      
        System.out.println(first + second);
    }
   
 
}
