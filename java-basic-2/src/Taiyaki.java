public class Taiyaki {

	//================　属性　==================

	//外から見えない
	private			String	 inn;

	//外から見える
	public			String	 innBox;

	//外から見えるけど変えられない
	public final	String	 bakepower;

	//外から見えて、全てのたい焼きが共有している
	public static	String	 taiyakiPhrase = "おいしいよ！";

	//----------------------------------------


	//================　機能　==================

	//新しいたい焼きを作る(newしたときに呼ばれる)
	public Taiyaki(String inn, String bakepower) {
		this.inn	 = inn;
		this.bakepower = bakepower;
		return;
	}


	//しゃべる
	public void 自己紹介(){

		//口に何か入ってたら喋れない
		if(this.innBox != null){
			System.out.println("><((( '< 「モゴモゴ」");
			return;
		}

		System.out.print("><((( '< 「ぼくの中身は" + this.inn + "で、焼き加減は" + this.bakepower + "だよ！」");
		System.out.println("「" + Taiyaki.taiyakiPhrase + "」");
		return;
	}


	//----------------------------------------

}

