package kr.co.kyhstudy.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AjaxService {
	
	public String createJSON() {
		
		String json = "";
		String[] data = {"�ڹ�", "�ڹٽ�ũ��Ʈ", "HTML", "CSS", "Oracle DBMS"};
		
		//{pubDate:����ð�����, lang:�迭�� ����,data:[{name:"�ڹ�",,,}]}
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("pubDate",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		jsonObj.put("lang", String.valueOf(data.length));
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonTmp = null;
		for(String str : data) {
			jsonTmp = new JSONObject();
			jsonTmp.put("name", str);
			jsonArr.add(jsonTmp);
		}// end for
		jsonObj.put("data", jsonArr);
		
		json = jsonObj.toJSONString();
		
		return json;
		
	}// createJSON

}// class
