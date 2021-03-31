package Q_10;

/*
    找出旋转数组中的最小元素
 */
public class RotateArray {
    public int findMin(int[] a){

        if (a.length == 0){
            return -1;
        }

        int length = a.length;
        int begin = 0;
        int end = length - 1;
        int mid = 0;

        while (begin <= end){
            mid = (begin + end) / 2;
            if (a[mid] > a[end]){
                // 最小值在右边 ， 且 [mid] 肯定不是最小值
                begin = mid + 1;
            }else if (a[mid] < a[end]){
                // 最小值在左边或就是 [mid]
                end = mid;
            }else if (a[mid] == a[end]){
                if (a[mid] <= a[begin]){
                    begin++;
                }else {
                    return a[begin];
                }
            }
        }

        return a[mid];
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,5,1};
        RotateArray rotateArray = new RotateArray();
        System.out.println(rotateArray.findMin(a));
    }
}
