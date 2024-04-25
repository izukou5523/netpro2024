// C言語では、#include に相当する
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		
		
			//Scanner scanner = new Scanner(System.in);
		
	while(true){
		try {
			System.out.println("何歳ですか?");
			System.out.println("'q'もしくは'e'を押すと終了します");
			//int age = scanner.nextInt();

			String line = reader.readLine();
			
        

			if(line.equals("q")||line.equals("e")){
				System.out.println("プログラムを終了します");
                break;

			}

			int age = Integer.parseInt(line);


			if(age<0||age<=120){
				System.out.println("0歳から119歳の間で入力してください");	
            continue;
			}
			

			

			

			int thisYear = 2024;
		    int birthYear = 0;

			String eraName = "";

			if (age >= 0 && age < 5) {
                birthYear = thisYear - age - 2019;
                eraName = "令和";
            } else if (age >=5 && age < 35) {
                birthYear = thisYear - age - 1989;
                eraName = "平成";
            } else if (age >= 35 && age < 98) {
                birthYear = thisYear - age - 1926;
                eraName = "昭和";
            } else if (age >= 95 && age < 110) {
                birthYear = thisYear - age - 1911;
                eraName = "大正";
            } else if (age >= 110 && age < 120) {
                birthYear = thisYear - age - 1901;
                eraName = "明治";
            } else {
				System.out.println("正しい年齢を入力してください。");
            }

			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは2030年には、" + (age + 6) + "歳ですね。");
			System.out.println("あなたが生まれた年は" + eraName + birthYear + "年ですね。");
		}
	
	
	    catch(Exception e) {
			System.out.println(e);
		}

		//scanner.close();


	}
}

}

//  課題    キーボードから数字を打ち込む
//  その結果、 あなたは、???歳ですね、と画面に表示させる。
//  その後、あなたは10年後、????歳ですね、と画面に表示させる。


