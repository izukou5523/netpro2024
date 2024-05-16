import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializable インタフェースを実装することで、このクラスはシリアライズ可能になります
class MyClass implements Serializable {
    // シリアライズ可能なフィールド
    private String name;
    private int age;

    // コンストラクタ
    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ゲッターとセッター
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // オブジェクトの状態を表示するメソッド
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        // MyClassのインスタンスを作成
        MyClass obj = new MyClass("Alice", 30);

        // オブジェクトをシリアライズしてファイルに保存する例
        try {
            FileOutputStream fileOut = new FileOutputStream("myobject.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ファイルからオブジェクトをデシリアライズして読み込む例
        try {
            FileInputStream fileIn = new FileInputStream("myobject.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyClass newObj = (MyClass) in.readObject();
            in.close();
            fileIn.close();

            // デシリアライズされたオブジェクトの状態を表示
            System.out.println("Deserialized object:");
            newObj.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


