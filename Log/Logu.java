import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logu {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		String str[] = new String[100]; //ファイル名を格納する配列
		String kikan ;
		String kikan2;
		int zikantai[] =new int[25]; //時間帯ごとのアクセス数を格納する配列
		int fairukazu=0; //入力されたファイルの数を格納する変数
		HashMap<String,Integer> name = new HashMap<String,Integer>();;

		for (int i=0; i<zikantai.length; i++){
			zikantai[i]=0;
		}

		for(int p=0; p<100; p++){
			InputStreamReader is = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(is);
	        System.out.println("解析したいファイルの名前を入力してください");
	        System.out.println("入力を終了するにはnoと入力してください");
	        str[p]= br.readLine();
	        if (str[p].equals("no")){
	        	fairukazu=p-1;
	        	break;
	        }
		}

		InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("期間を設定する場合は期間を入力してください　例20190318");
        System.out.println("機関を設定しない場合はnoと入力してください");
        kikan= br.readLine();

        if(kikan.equals("no")){
        	for (int o=0; o<=fairukazu; o++){
    			try {
    				String Logu = str[o];
    				BufferedReader L01 = new BufferedReader(new FileReader(Logu));
    	           // Pattern L02 = Pattern.compile("(.+) .+ .+ \\[(.+)\\] \"(.+)\" .+ .+ \".+\" \"(.+)\"");
    	            Pattern L02 = Pattern.compile("(.+) .+ .+ \\[............(..).+\\] \"(.+)\" .+ .+ \".+\" \"(.+)\"");
    	            String L03;
    	            while( (L03 = L01.readLine()) != null ) {
    	            	//一覧を表示するときに使う
    	            	//System.out.println(L03);
    	                Matcher L04 = L02.matcher(L03);
    	                if (L04.matches()) {
    	                		/*System.out.println("リモートname = " + L04.group(1));
    	                        System.out.println("時間帯" + L04.group(2));
    	                        System.out.println("http = " + L04.group(3));
    	                        System.out.println("agent = " + L04.group(4));*/

    	                		if(name.containsKey(L04.group(1))){
    	                			int a=name.get(L04.group(1));
    	                			name.put(L04.group(1),a+1);
    	                		}
    	                		else {
    	                			name.put(L04.group(1),1);
    	                		}


    	                		int zikan = Integer.parseInt(L04.group(2));

    	                		switch (zikan) {
    	                		case 0:
    	                			zikantai[0] +=1;
    	                			break;
    	                		case 1:
    	                			zikantai[1]+=1;
    	                			break;
    	                		case 2:
    	                			zikantai[2]+=1;
    	                			break;
    	                		case 3:
    	                			zikantai[3]+=1;
    	                			break;
    	                		case 4:
    	                			zikantai[4]+=1;
    	                			break;
    	                		case 5:
    	                			zikantai[5]+=1;
    	                			break;
    	                		case 6:
    	                			zikantai[6]+=1;
    	                			break;
    	                		case 7:
    	                			zikantai[7]+=1;
    	                			break;
    	                		case 8:
    	                			zikantai[8]+=1;
    	                			break;
    	                		case 9:
    	                			zikantai[9]+=1;
    	                			break;
    	                		case 10:
    	                			zikantai[10]+=1;
    	                			break;
    	                		case 11:
    	                			zikantai[11]+=1;
    	                			break;
    	                		case 12:
    	                			zikantai[12]+=1;
    	                			break;
    	                		case 13:
    	                			zikantai[13]+=1;
    	                			break;
    	                		case 14:
    	                			zikantai[14]+=1;
    	                			break;
    	                		case 15:
    	                			zikantai[15]+=1;
    	                			break;
    	                		case 16:
    	                			zikantai[16]+=1;
    	                			break;
    	                		case 17:
    	                			zikantai[17]+=1;
    	                			break;
    	                		case 18:
    	                			zikantai[18]+=1;
    	                			break;
    	                		case 19:
    	                			zikantai[19]+=1;
    	                			break;
    	                		case 20:
    	                			zikantai[20]+=1;
    	                			break;
    	                		case 21:
    	                			zikantai[21]+=1;
    	                			break;
    	                		case 22:
    	                			zikantai[22]+=1;
    	                			break;
    	                		case 23:
    	                			zikantai[23]+=1;
    	                			break;
    	                		case 24:
    	                			zikantai[24]+=1;
    	                			break;
    	                		}

    	                } else {
    	                    System.out.println("解析できない行がありました：" + L03);
    	                }
    	            }
    	            L01.close();

    	        } catch(IOException L05) {
    	            System.out.println(str[o] + "を読み込み中に例外が発生しました。");
    	        }
    		}
        }
        else {
        	InputStreamReader iss = new InputStreamReader(System.in);
            BufferedReader brr = new BufferedReader(is);
            System.out.println("～");
            kikan2= br.readLine();

            int year=Integer.parseInt(kikan.substring(0,4));
            int month=Integer.parseInt(kikan.substring(4,6));
            int day = Integer.parseInt(kikan.substring(6,8));

            int year2=Integer.parseInt(kikan2.substring(0,4));
            int month2=Integer.parseInt(kikan2.substring(4,6));
            int day2 = Integer.parseInt(kikan2.substring(6,8));


            for (int o=0; o<=fairukazu; o++){
    			try {
    				String Logu = str[o];
    				BufferedReader L01 = new BufferedReader(new FileReader(Logu));
    	           // Pattern L02 = Pattern.compile("(.+) .+ .+ \\[(.+)\\] \"(.+)\" .+ .+ \".+\" \"(.+)\"");
    	            Pattern L02 = Pattern.compile("(.+) .+ .+ \\[(..).(...).(....).(..).+\\] \"(.+)\" .+ .+ \".+\" \"(.+)\"");
    	            String L03;
    	            while( (L03 = L01.readLine()) != null ) {
    	            	//一覧を表示するときに使う
    	            	//System.out.println(L03);
    	                Matcher L04 = L02.matcher(L03);
    	                if (L04.matches()) {
    	                		/*System.out.println("リモートname = " + L04.group(1));
    	                        System.out.println("時間帯" + L04.group(2));
    	                        System.out.println("http = " + L04.group(3));
    	                        System.out.println("agent = " + L04.group(4));*/


    	                	int year3=Integer.parseInt(L04.group(4));
    	                	int month3=month(L04.group(3));
    	                	int day3=Integer.parseInt(L04.group(2));

    	                	if(year<=year3 && year2>=year3 && month<=month3 && month2>=month3 && day<=day3 && day2>=day3){
    	                		if(name.containsKey(L04.group(1))){
    	                			int a=name.get(L04.group(1));
    	                			name.put(L04.group(1),a+1);
    	                		}
    	                		else {
    	                			name.put(L04.group(1),1);
    	                		}


    	                		int zikan = Integer.parseInt(L04.group(5));

    	                		switch (zikan) {
    	                		case 0:
    	                			zikantai[0] +=1;
    	                			break;
    	                		case 1:
    	                			zikantai[1]+=1;
    	                			break;
    	                		case 2:
    	                			zikantai[2]+=1;
    	                			break;
    	                		case 3:
    	                			zikantai[3]+=1;
    	                			break;
    	                		case 4:
    	                			zikantai[4]+=1;
    	                			break;
    	                		case 5:
    	                			zikantai[5]+=1;
    	                			break;
    	                		case 6:
    	                			zikantai[6]+=1;
    	                			break;
    	                		case 7:
    	                			zikantai[7]+=1;
    	                			break;
    	                		case 8:
    	                			zikantai[8]+=1;
    	                			break;
    	                		case 9:
    	                			zikantai[9]+=1;
    	                			break;
    	                		case 10:
    	                			zikantai[10]+=1;
    	                			break;
    	                		case 11:
    	                			zikantai[11]+=1;
    	                			break;
    	                		case 12:
    	                			zikantai[12]+=1;
    	                			break;
    	                		case 13:
    	                			zikantai[13]+=1;
    	                			break;
    	                		case 14:
    	                			zikantai[14]+=1;
    	                			break;
    	                		case 15:
    	                			zikantai[15]+=1;
    	                			break;
    	                		case 16:
    	                			zikantai[16]+=1;
    	                			break;
    	                		case 17:
    	                			zikantai[17]+=1;
    	                			break;
    	                		case 18:
    	                			zikantai[18]+=1;
    	                			break;
    	                		case 19:
    	                			zikantai[19]+=1;
    	                			break;
    	                		case 20:
    	                			zikantai[20]+=1;
    	                			break;
    	                		case 21:
    	                			zikantai[21]+=1;
    	                			break;
    	                		case 22:
    	                			zikantai[22]+=1;
    	                			break;
    	                		case 23:
    	                			zikantai[23]+=1;
    	                			break;
    	                		case 24:
    	                			zikantai[24]+=1;
    	                			break;
    	                		}

    	                	}

    	                } else {
    	                    System.out.println("解析できない行がありました：" + L03);
    	                }
    	            }
    	            L01.close();

    	        } catch(IOException L05) {
    	            System.out.println(str[o] + "を読み込み中に例外が発生しました。");
    	        }
    		}

        }


         //アクセス数の表示
         System.out.println("時間帯ごとのアクセス件数");
		 for (int j=0; j<zikantai.length; j++){
			 if(zikantai[j]>0){
				 System.out.println(j+"時のアクセス件数は"+zikantai[j]);
			 }

		 }

		 List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(name.entrySet());



	        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
	            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
	            {
	                return obj2.getValue().compareTo(obj1.getValue());
	            }
	        });

	        System.out.println("リモートホスト別のアクセス件数");
	        // 7. ループで要素順に値を取得する
	        for(Entry<String, Integer> entry : list_entries) {
	            System.out.println(entry.getKey() + " のアクセス件数は " + entry.getValue());
	        }


	}

	public static int month(String x){
		int a=0;
		switch (x) {
			case "Jan":
				a=1;
				break;
			case "Feb":
				a=2;
				break;
			case "Mar":
				a=3;
				break;
			case "Apr":
				a=4;
				break;
			case "May":
				a=5;
				break;
			case "Jun":
				a=6;
				break;
			case "Jul":
				a=7;
				break;
			case "Aug":
				a=8;
				break;
			case "Sep":
				a=9;
				break;
			case "Oct":
				a=10;
				break;
			case "Nov":
				a=11;
				break;
			case "Dec":
				a=12;
				break;
		}
		return a;
	}
}
































