public class DinnerFullCourse {

    private Dish[] list = new Dish[5]; // [0]-[4]の計5個

    public static void main(String[] args) {
        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }

    DinnerFullCourse() {
        list[0] = new Dish();
        list[0].setName("特選シーザサラダ");
        list[0].setValune(2);

        list[1] = new Dish();
        list[1].setName("銀しゃり");
        list[1].setValune(2);

        list[2] = new Dish();
        list[2].setName("梅干し");
        list[2].setValune(20);

        list[3] = new Dish();
        list[3].setName("ステーキ");
        list[3].setValune(50);

        list[4] = new Dish();
        list[4].setName("デザート");
        list[4].setValune(15);
    }// DinnerFullCourseコンストラクターエンド

    void eatAll() {
        StringBuilder str = new StringBuilder("たかしへ、ママです。今日の晩御飯は");
        for (Dish dish : list) {
            str.append(dish.getName()).append("=").append(dish.getValune()).append(",");
        }
        str.setLength(str.length() - 1); // 最後のカンマを削除
        str.append("よ");
        System.out.println(str.toString());
    }// eatAll end

}// DinnerFullCourse end

