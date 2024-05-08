public class XmasTreeKadai {
    public static void main(String[] args) {
        //int X=Integer.parseInt(args[0]);
        //int Y=Integer.parseInt(args[1]);


        System.out.println("Draw your own xmas tree with multi-loop!");
    
        /*
        while(i<10) {
            Scanner scan = new Scanner(System.in);

            String str = scan.next();
            System.out.println("最初のトークンは: " + str);
            System.out.println("文字を分割すると・・・");
            String[] word = str.split(",");//splitメソッドの引数に、どこの文字で分割するか指定します。この場合は空白文字。
            for(String w:word) {
                System.out.println(w);
            }
            System.out.println("word[0]"+word[0]);
            System.out.println("word[1]"+word[1]);
            System.out.println("word[2]"+word[2]);
            System.out.println("word[3]"+word[3]);
            //19,3,7,c
            //first = Integer.parseInt(str);
            System.out.println("----次の数字の入力をお願いします ");
        }
        */
        System.out.println("---------");

        System.out.print("*");
        System.out.println("\n");

        System.out.println("---------");

        System.out.println("----step2-----");

        int N = 20;

        for(int i=0;i<N;i++){
            for(int j=0;j<=N-i;j++){
                if((j+i) % 2 == 0){
                System.out.print("`");
                }
                else{
                    System.out.print(" ");
                }
            }


            for(int j=0;j<=i*2;j++){
                System.out.print("*");
            }

            for(int j=0;j<=N-i;j++){
                if(((j+i))% 2 == 0){
                System.out.print("` ");
                }
            }
        System.out.print("\n");
        }

        int trunkHeight = N*4 /3 ;
        int trunkOffset = N / 2;

        for (int i = 0; i < trunkHeight; i++) {
            for (int j = 0; j < trunkOffset+1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("---------");


    }
}
//https://docs.oracle.com/javase/jp/8/docs/api/java/lang/Integer.html
