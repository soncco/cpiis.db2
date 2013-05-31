/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author brau
 */
public class Convert {

    public static final int INT_SIZE = 4;
    public static final int LONG_SIZE = 8;
    public static final int SHORT_SIZE = 2;
    public static final int CHAR_SIZE = 2;
    public static final int FLOAT_SIZE = 4;
    public static final int DOUBLE_SIZE = 8;
    
    public Convert() {}

    public static void toByte(int i, byte [] bytes, int o) {
        for (byte b = 0; b <= 3; b++)
            bytes[o+b] = (byte) (i >>> (3 - b)*8);
    }
    
    public static byte [] toByte(int i) {
        byte b[] = new byte[4];
        toByte(i, b, 0);
        return b;
    }

    public static void toByte(short w, byte [] bytes, int o) {
        for (byte b = 0; b <= 1; b++)
            bytes[o+b] = (byte) (w >>> (1 - b)*8);
    }

    public static byte [] toByte(short w) {
        byte b[] = new byte[2];
        toByte(w, b, 0);
        return b;
    } // toByte()

    public static void toByte(long l, byte [] bytes, int o) {
        for (byte b = 0; b <= 7; b++)
            bytes[o+b] = (byte)(int) (l >>> (7 - b)*8);
    }

    public static byte [] toByte (long l) {
        byte b[] = new byte[8];
        toByte(l, b, 0);
        return b;
    } // toByte()

    public static void toByte(char c, byte [] bytes, int o) {
        for (byte b = 0; b <= 1; b++)
            bytes[o+b] = (byte) (c >>> (1-b)*8);
    }

    public static byte [] toByte (char c) {
        byte b[] = new byte[2];
        toByte(c, b, 0);
        return b;
    }

    public static void toByte(float f, byte [] bytes, int o) {
        int i = Float.floatToIntBits(f);
        toByte(i, bytes, o);
    }

    public static byte [] toByte (float f) {  
        byte b[] = new byte[4];
        toByte(f, b, 0);
        return b;
    }

    public static void toByte(double d, byte [] bytes, int o) {
        long l = Double.doubleToLongBits(d);
        toByte(l, bytes, o);
    }

    public static byte [] toByte (double d) {
        byte [] b = new byte[8];
        toByte(d, b, 0);
        return b;
    }

    public static byte [] toByte(String s) {
        byte [] b = new byte[2*s.length()];
        toByte(s, b, 0);
        return b;
    }

    public static byte [] toByte(String s, byte [] bytes, int o) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            byte [] two = toByte(s.charAt(i));
            bytes[2*i] = two[0];
            bytes[2*i+1] = two[1];
        }
        return bytes;
    }

    public static int toInt (byte b[]) {
        return toInt(b, 0);
    }

    public static int toInt (byte b[], int o) {
        int i = 0;
        for (int b0 = 0; b0 <= 3; b0++) {
            int j;
            if (b[o+b0] < 0) {
                j = (byte) (b[o+b0] & 0x7f);
                j |= 0x80;
            }
            else {
                j = b[o+b0];
            }
            i |= j;
            if (b0 < 3) i <<= 8;
        }
        return i;
    }

    public static short toShort(byte b[]) {
        return toShort(b, 0);
    }
    
    public static short toShort(byte b[], int o) {
        short word0 = 0;
        for (int b0 = 0; b0 <= 1; b0++) {
            short word1;
            if (b[o+b0] < 0) {
                word1 = (byte)(b[o+b0] & 0x7f);
                word1 |= 0x80;
            }
            else {
                word1 = b[o+b0];
            }
            word0 |= word1;
            if(b0 < 1) word0 <<= 8;
        }
        return word0;
    }
    
    public static long toLong (byte b[]) {
        return toLong(b, 0);
    }

    public static long toLong (byte b[], int o) {
        long l = 0L;
        for (int b0 = 0; b0 <= 7; b0++) {
            long l1;
            if (b[o+b0] < 0) {
                l1 = (byte)(b[o+b0] & 0x7f);
                l1 |= 128L;
            }
            else {
                l1 = b[o+b0];
            }
            l |= l1;
            if(b0 < 7) l <<= 8;
        }
        return l;
    }
    
    public static char toChar (byte b[]) {
        return toChar(b, 0);
    }
    
    public static char toChar (byte b[], int o) {
        char c = 0;
        c = (char)((c | (char)b[o]) << 8);
        c |= (char)b[o+1];
        return c;
    }
    
    public static float toFloat (byte b[]) {
        return toFloat(b, 0);
    }
    
    public static float toFloat (byte b[], int o) {
        float f = 0.0F;
        Float float1 = new Float(f);
        int i = toInt(b, o);
        f = Float.intBitsToFloat(i);
        return f;
    }
    
    
    public static double toDouble (byte b[]) {
        return toDouble(b, 0);
    }
    
    public static double toDouble (byte b[], int o) {
        double d = 0.0D;
        Double double1 = new Double(d);
        long l = toLong(b, o);
        d = Double.longBitsToDouble(l);
        return d;
    }

    public static String toString(byte [] b) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length-1; i = i+2) {
            byte [] two = new byte[2];
            two[0] = b[i];
            two[1] = b[i+1];
            sb.append(toChar(two));
        }
        return sb.toString();
    } 
}

