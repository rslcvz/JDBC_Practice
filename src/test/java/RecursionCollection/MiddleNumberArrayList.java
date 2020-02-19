package RecursionCollection;

import org.testng.annotations.Test;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;
import java.util.List;

public class MiddleNumberArrayList {


  @Test
  public void middleNum(){

        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        
        int sum = num.get(num.size()/2 );
        System.out.println("sum = " + sum);



    }
}
