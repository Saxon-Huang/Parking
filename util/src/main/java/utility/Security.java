package utility;

import constants.ConstAttributes;
import constants.ErrorMessages;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    public static String md5(String src) {
        if (src == null || src.length() == 0) throw new RuntimeException(ErrorMessages.INVALID_USERNAME);
        try {
            String algorithm = "md5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] input = src.getBytes();
            byte[] output = messageDigest.digest(input);
            BigInteger bigInteger = new BigInteger(1, output);
            String encoded = bigInteger.toString(16);
            return encoded;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
