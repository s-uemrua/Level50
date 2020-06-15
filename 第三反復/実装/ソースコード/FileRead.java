package project;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileRead {
	 FileReader fr;
	 BufferedReader br;
	public void read() {
        try {
            //ファイルを読み込む
             fr = new FileReader("C:\\hoge\\log.txt");
             br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ画面出力する
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            //終了処理
            br.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println("ファイルが存在しません");
        }catch(IOException e) {
        	   e.printStackTrace();
        }
    }

}