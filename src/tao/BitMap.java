package tao;

public class BitMap {
    public int[] arr;
    public int i;
    public int numIndex = i / 32;
    public int bitIndex = i % 32;
    //获取第i位信息
    public int target = arr[numIndex] & (1 << bitIndex);

    //将第i位改为1
    public void change1(int i) {
        arr[numIndex] |= (1 << bitIndex);
    }

    //将第i位改为0
    public void change0(int i) {
        arr[numIndex] &= ~(1 << bitIndex);
    }

}
