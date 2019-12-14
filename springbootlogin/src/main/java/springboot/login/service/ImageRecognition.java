package springboot.login.service;

import java.io.File;
import java.io.IOException;
import springboot.login.utility.operateFile;

public class ImageRecognition {
	public static String recognize() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
//		Process process = runtime.exec(new String[] {"/bin/sh","-c",
//				"cd /Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/ && python faceRec1.py  >> result.txt && python faceRec2.py >> Tresult.txt"});
		Process process = runtime.exec(new String[] {"/bin/sh","-c",
				"cd /Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/ && python faceRec1.py && python faceRec2.py"});
		process.waitFor();
//		读取txt文件操作
		String result = operateFile.read("/Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/result.txt","UTF-8");
//		File dele2 = new File("/Users/a_piao/Desktop/springbootlogin/src/main/resources/static/data/result.txt");
//		dele2.delete();
        return result;
	}

}
