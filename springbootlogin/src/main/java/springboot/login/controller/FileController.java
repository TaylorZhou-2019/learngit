package springboot.login.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import springboot.login.utility.uploadFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springboot.login.bean.DangerList;
import springboot.login.bean.Record;
import springboot.login.service.DangerListService;
import springboot.login.service.ImageRecognition;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import springboot.login.service.RecordService;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private RecordService recordService;
	@Autowired
	private DangerListService dangerListService;

	@RequestMapping(value="/upload",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String upload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException, InterruptedException {
		File fi1 = new File("/Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/picture1.jpg");
		file.transferTo(fi1);
		return "success";
	}

	@RequestMapping(value="/upload1",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String upload1(@RequestParam("file1")MultipartFile file,HttpSession session) throws IllegalStateException, IOException, InterruptedException {
		File fi2 = new File("/Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/picture2.jpg");
		file.transferTo(fi2);
		String result = ImageRecognition.recognize();
		System.out.println(result);
		//转化为json用来提取
		JSONObject json = JSON.parseObject(result);

		//获取对应key的值
		String match=json.getString("match");
		int suspect= Integer.parseInt(json.getString("suspect"));
		String criminal=json.getString("criminal");

		//将记录加入record表
		Record record = new Record();
		record.setUsername((String) session.getAttribute("username"));
		record.setisMatch(Integer.parseInt(match));
		record.setSuspect(suspect);
//		System.out.println(record);
		recordService.addrecord(record);

		//检测危险记录，将其加入danger表
		if (suspect != 0 ){
			DangerList danger = new DangerList();
			danger.setUsername((String) session.getAttribute("username"));
			danger.setSuspiciousID(criminal);
			danger.setDangerLevel("high");
			danger.setSettle("未处理");
			dangerListService.adddanger(danger);

		}
//		result = Translate.toJson(result);
//		fi2.delete();

		return result;
	}

	@RequestMapping(value="/upCropFile",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String upCropFile(@RequestParam("fileData") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException, InterruptedException {
//		System.out.println("=====================uploadLicence");
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String fileData = request.getParameter("fileData");//Base64编码过的图片数据信息，对字节数组字符串进行Base64解码
//		System.out.println(request.getParameter("fileData"));
//		String imgPath = uploadFile.uploadFile(fileData);//进行文件上传操作，上传到服务器中存放（这里是上传到服务器项目文件夹中存到）
		File fi3 = new File("/Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/picture1.jpg");
		file.transferTo(fi3);
		return "success";
	}
}