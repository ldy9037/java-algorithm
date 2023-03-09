package lv1;

public class Q9 
{
    public static void main(String[] args)
    {
        String def = "banana"; 

        SolutionQ9 solution = new SolutionQ9(def);
        consoleOut( solution.result() );
    }

    private static void consoleOut(int result) 
    {
        System.out.println(result);
    }
}

class SolutionQ9 
{
    String def;
    
    SolutionQ9(String def)
    {
        this.def = def;
    }
    
    public int result()
    {
        int result = 0;    
        int[] count = {0,0};
        Character start = null;
        
        for (Character c : this.def.toCharArray()) 
        {
            if (null == start) 
            {
                start = c;
            }

            ++count[ c.equals(start) ? 0 : 1 ];
            
            if (count[0] == count[1]) 
            {
                count[0] = 0;
                count[1] = 0;

                ++result;
                start = null;
            }
        }

        if (null != start) 
        {
            ++result;
        }

        return result;
    }
}
