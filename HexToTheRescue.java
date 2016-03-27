
import com.sun.tools.javac.util.StringUtils;

import java.math.BigInteger;
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
    private static String[] hexToBinary(String[] strArray) {
        String[] results = new String[strArray.length];
        for(int i=0; i<strArray.length; i++) {
            String output = new BigInteger(strArray[i], 16).toString(2);
            if (output.length() < 8){
                int preZero = 8 - output.length();
                String addingZeroString = new String(new char[preZero]).replace("\0", "0");

                results[i] = addingZeroString + output;
            } else {
                results[i] = output;
            }

        }
        return results;
    }

    public static void main(String[] args) {

        HexToTheRescue httr = new HexToTheRescue();
        String message = "SMS Rulz";

        String[] hexes = httr.stringToHex(message);
        System.out.println(Arrays.toString(hexes));

        String[] binaries = httr.hexToBinary(hexes);
        System.out.println(Arrays.toString(binaries));

        String[] takeFirst = httr.takeFirst(binaries);
        System.out.println(Arrays.toString(takeFirst));

        String[] sevenBins = httr.sevenBins(takeFirst);
        System.out.println(Arrays.toString(sevenBins));

        String[] newHex = httr.binaryToHex(sevenBins);
        System.out.println("new hex: " + Arrays.toString(newHex));


    }

    private String[] binaryToHex(String[] sevenBins) {
        String[] results = new String[sevenBins.length];

        for(int i=0; i<sevenBins.length; i++) {
            results[i] = Integer.toHexString(Integer.parseInt(sevenBins[i], 2)).toUpperCase();
        }
        return results;
    }

    private String[] sevenBins(String[] takeFirst) {
        String[] results = new String[takeFirst.length-1];


        for (int i=0; i<takeFirst.length-1; i++) {
            String getBits = takeFirst[i+1].substring(6-i);
            results[i] = getBits + takeFirst[i].substring(0, 7-i);
        }
        return results;
    }

    private String[] takeFirst(String[] binaries) {
        String[] results = new String[binaries.length];

        for (int i=0; i<binaries.length; i++) {
            results[i] = binaries[i].substring(1, binaries.length);
        }
        return results;
    }
}
