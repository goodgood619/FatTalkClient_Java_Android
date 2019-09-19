package Model;

public class Endian {
    public static byte[] GetlittleEndian(int i) {
        byte[] buf = new byte[4];
        buf[3] = (byte)((i>>>24) & 0xFF);
        buf[2] = (byte)((i>>16) & 0xFF);
        buf[1] = (byte)((i>>8) & 0xFF);
        buf[0] = (byte)((i>>0) & 0xFF);
        return buf;
    }
    public static int getBigEndian(byte[] data,int index) {
        int[] array = new int[4];
        int idx = 0;
        for(int j = 1; j <= 4; j++) array[idx++] = (int)(data[index+4-j] & 0xFF);
        return ((array[0]<<24)+(array[1]<<16) + (array[2]<<8)+(array[3]<<0));
    }
}
