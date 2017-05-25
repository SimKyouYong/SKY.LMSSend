package sjy.skylmssend.common;

import android.app.Activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class CommonUtil {
	private static CommonUtil _instance;


	public static String TYPE;
	public static String MYPROFILE_IMG;


	static {
		_instance = new CommonUtil();
		try {
			_instance.TYPE 			= 	   		"P";
			_instance.MYPROFILE_IMG 			= 	   		"";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CommonUtil getInstance() {
		return _instance;
	}

	
	public ArrayList<String> Token_String(String url , String token){
		ArrayList<String> Obj = new ArrayList<String>();

		StringTokenizer st1 = new StringTokenizer( url , token);
		while(st1.hasMoreTokens()){
			Obj.add(st1.nextToken());
		}
		return Obj;
	}

	public String JsonReplace(String value){
		return value.replace("[[" , "").replace("]]" , "");
	}
	public String JsonnotReplace(String value){
		return value.replace("[" , "").replace("]" , "");
	}
	public String JsonOneReplace(String value){
		return value.replace("[[" , "[").replace("]]" , "]");
	}
	//언어 값 서버에 맞게 셋팅
	/*
	* 한글 : ko -> ko-KR
	* 일어 : js -> ja-JP
	* 영어 : en -> en-US
	* */
	public String GetLanguage(String value){
		if 		(value.equals("ko")){			value = "ko-KR";		}
		else if (value.equals("ja")){			value = "ja-JP";		}
		else if (value.equals("en")){			value = "en-US";		}
		return value;
	}
	/**
	 * 특정 날짜에 대하여 요일을 구함(일 ~ 토)
	 * @param date
	 * @param dateType
	 * @return
	 * @throws Exception
	 */
	public String getDateDay(String date, String dateType) throws Exception {
		String day = "" ;
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateType) ;
		Date nDate = dateFormat.parse(date) ;
		Calendar cal = Calendar.getInstance() ;
		cal.setTime(nDate);
		int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
		switch(dayNum){
			case 1:
				day = "일";
				break ;
			case 2:
				day = "월";
				break ;
			case 3:
				day = "화";
				break ;
			case 4:
				day = "수";
				break ;
			case 5:
				day = "목";
				break ;
			case 6:
				day = "금";
				break ;
			case 7:
				day = "토";
				break ;
		}
		return day ;
	}
	public String[] getTime(String start , String end , String start_day , String end_day){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;

		Date startDate = null;
		Date endDate = null;
		try {
			startDate = dateFormat.parse(start_day + " " + start);
			endDate = dateFormat.parse(end_day + " " + end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long proc = endDate.getTime() - startDate.getTime();
		long min=proc/60000;

		StringBuffer diffTime=new StringBuffer();
		diffTime.append( min);
		//분을 시간 으로 변경
		int real_hour = Integer.parseInt(diffTime.toString()) / 60 ;
		int real_min  = Integer.parseInt(diffTime.toString()) % 60 ;
		String str[] = new String[2];
		str[0] = "" + real_hour;
		str[1] = "" + real_min;
		return str;
	}
	public float getPersent(float hh , float mm){
		float sum_mm = hh*60 + mm;
		float persent = (sum_mm) / (24*60) * 100;
		return persent;
	}

	/*
	* 3자리 단위 , 표기
	* ex) 1234 -> 1,234
	* */
	public String setNumberReplace(String num){
		int count = num.length();
		String str = "";
		if (count > 3){
			str = num.substring(0 , (count-3)) + "," + num.substring((count-3) , num.length());
		}else{
			str = num;
		}
		return str;
	}
	/*
	* 오늘 날짜인지 비교
	* @Param
	* true  (오늘날짜 인 경우)
	* false (오늘날짜가 아닌 경우)
	* */
	public Boolean GetToday(int Year , int Month , int Day){
		Date date = new Date ( );
		Calendar Today = Calendar.getInstance ( );
		Today.setTime (date);

		Calendar c1 = Calendar.getInstance();
		c1.set(Year, Month, Day);

		if (c1.equals(Today))
			return true;
		else
			return false;
	}
	public String getStringResourceByName(Activity av , String aString) {
		String packageName = av.getPackageName();
        //Log.e("SKY", "LAN1 : " + Check_Preferences.getAppPreferences(av, "LANGUAGE")); // ko-KR
        //if (Check_Preferences.getAppPreferences(av, "LANGUAGE").equals("ja-JP"))
        //    aString = "jp_" + aString;
		//Log.e("SKY", "aString : " + aString);

		int resId = av.getResources().getIdentifier(aString, "string", packageName);
		return av.getString(resId);
	}

}
