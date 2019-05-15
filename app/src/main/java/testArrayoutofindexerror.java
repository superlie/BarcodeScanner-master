public class testArrayoutofindexerror {

    public static  int InversePairs(int [] array) {
        int sum=0;
        if(array == null || array.length ==0)
            return 0;
        for(int i=0;i<array.length-1;i++){
            for(int j= i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    sum++;
                }
            }
        }
        return sum%1000000007;
    }

    static int count = 0;
    public static int InversePairs2(int [] array) {
        if(array == null || array.length ==0)
            return 0;
        mergeSort(array, 0, array.length -1);
        return count;

    }
    public  static void mergeSort(int []array, int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, mid+ 1, end);
        }
    }
    public  static void merge(int []array,int start1,int end1, int start2, int end2) {
        int i = end1;
        int j = end2;
        int k = end2 - start1 ;
        int [] temp = new int[end2- start1 +1];
        while(i >= start1 && j >=start2) {
            if(array[i] > array[j]) {
                //假设此时两个归并的是17 19 22 || 16 18 21
                //那么22大于21，所以可以看出对应22
                //有三个，22 16 22 18 22 21
                temp[k--] = array[i--];
                count = count + j - start2 +1;
                count %= 1000000007;
            }
            else
                temp[k--] = array[j--];
        }
        while(i >= start1)
            temp[k--] = array[i--];
        while(j >= start2)
            temp[k--] = array[j--];

        int m = start1;
        for(int element:temp)
            array[m++] = element;

    }

    public  static  void main(String[] args){
        int [] array ={1,2,3,4,5,6,7,0};
        System.out.print(InversePairs2(array));
    }
}
