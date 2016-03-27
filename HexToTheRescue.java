import java.util.Arrays;

/**
 * Created by riza on 3/26/16.
 */
public class HexToTheRescue {

    private String[] stringToHex(String str) {
        char[] chars = str.toCharArray();
        String[] results = new String[chars.length];
        for(int i=0; i<chars.length; i++) {
            String output = Integer.toHexString((int) chars[i]);
            results[i] = output;

        }
        return results;
    }

    public static void main(String[] args) {

        HexToTheRescue httr = new HexToTheRescue();
        String message = "SMS Rulz";
        System.out.println(httr.stringToHex(message));


    }
}
