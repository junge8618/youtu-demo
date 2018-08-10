package com.junge.demo.youtu;

import org.json.JSONObject;

public class IdCardOcrDemo {
	// appid, secretid secretkey请到http://open.youtu.qq.com/获取
	// 请正确填写把下面的APP_ID、SECRET_ID和SECRET_KEY
	public static final String APP_ID = "10135300";
	public static final String SECRET_ID = "AKIDjNtFEj4Pagic2OfciiZEtPjO0ZXHs9Az";
	public static final String SECRET_KEY = "rGfuztc9VgnjdPzNdqsjOwJUUIJCxWt4";
	public static final String USER_ID = "2254556006"; // qq号

	public static void main(String[] args) {

		try {
			Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY, Youtu.API_YOUTU_END_POINT, USER_ID);
			JSONObject response;
			// response=
			// faceYoutu.FaceCompareUrl("http://open.youtu.qq.com/content/img/slide-1.jpg","http://open.youtu.qq.com/content/img/slide-1.jpg");
			// response = faceYoutu.DetectFace("test.jpg",1);
			// response =
			// faceYoutu.ImageTerrorismUrl("http://open.youtu.qq.com/app/img/experience/terror/img_terror01.jpg");
			// response =
			// faceYoutu.CarClassifyUrl("http://open.youtu.qq.com/app/img/experience/car/car_01.jpg");
			// response =
			// faceYoutu.BizLicenseOcrUrl("http://open.youtu.qq.com/app/img/experience/char_general/ocr_yyzz_01.jpg");
			// response =
			// faceYoutu.CreditCardOcrUrl("http://open.youtu.qq.com/app/img/experience/char_general/ocr_card_1.jpg");
			/*response = faceYoutu.IdCardOcrImgStr(com.junge.demo.youtu.ImgFileUtil2.getImageStr("E://idcard_0.jpg"), 0);
			System.out.println(response);*/
			
//			response = faceYoutu.IdCardOcrImgStr(com.junge.demo.youtu.ImgFileUtil2.getImageStr("E://idcard_1.jpg"), 1);
//			System.out.println(response);

			response = faceYoutu.BizLicenseOcr("E://三证合一营业执照.jpg"); // get
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
