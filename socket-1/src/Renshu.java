class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    //ここに続きを実装していく。
    public int sumUpToN(int n){
        int sum = 0;
        for(int j = 0; j <= n; j++){
            sum = sum + j;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q){
        int sum = 0;
        if(p <= q){
            for(int i = p; i <= q; i++){
                sum =sum + i;
            }
            return sum;
        } else{   
            return -1;
        }
    }

    public int sumFromArrayIndex(int[] a, int index){
        int sum = 0;
        if(a.length > index){
            for(int i = index; i < a.length; i++){
                sum = sum + a[i];
            }
            return sum;
        } else{
            return -1;
        }
    }

    public int selectMaxValue(int[] a){
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        if(max >= 0){
            return max;
        } else{
            return -1;
        }
    }

    public int selectMinValue(int[] a){
        int min = a[0];
        for(int i = 1; i < a.length; i++){
            if(min > a[i]){
                min = a[i];
            }
        }
        return min;
    }

    public int selectMaxIndex(int[] a){
        int max = a[0];
        int maxIndex = 0;
        for(int i = 1; i < a.length; i++){
            if(max < a[i]){
                max = a[i];
                maxIndex = i;
            } 
        }
        return maxIndex;   
    }

    public int selectMinIndex(int[] a){
        int min = a[0];
        int minIndex = 0;
        for(int i = 1; i < a.length; i++){
            if(min > a[i]){
                min = a[i];
                minIndex = i;
            } 
        }
        return minIndex;   
    }

    public void swapArrayElements(int[] p, int i, int j){
        int tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;

    }

    public boolean swapTwoArrays(int[]a, int[]b){
        if(a.length == b.length){
            int[] tmp = new int [a.length];
            for(int i = 0; i < a.length; i++){
                tmp[i] = a[i];
                a[i] = b[i];
                b[i] = tmp[i];
            }
            return true;  
        } else{
            return false;
        }

    }
    
    
}