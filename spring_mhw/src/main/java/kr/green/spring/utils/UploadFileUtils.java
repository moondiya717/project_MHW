package kr.green.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	/* 기능 : 파일 주소와 파일명과 파일이 주어지면 해당 파일주소에 업로드일을 기준으로 년/월/일/ 폴더를 만들어서
	 * 		 해당 폴더에 파일을 업로드하는 메소드
	 * 매개변수 : uploadPath - 업로드할 파일 경로, 
	 * 			originalName - 실제 파일명, 
	 * 			fileData - 업로드할 실제 파일 데이터가 있는 배열 
	 * 리턴타입 : 저장된 파일경로와 파일명으로 된 문자열
	 * 예시 : uploadPath = "D:\\JAVA_mhw\\uploadfiles" , originalName = "dog.jpg"
	 * 		fileData에는 dog.jpg 파일이 배열로 담겨있다고 생각하면 됨
	 * */
	
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		//UUID 생성
		UUID uid = UUID.randomUUID(); //36개 16진수로된 문자+숫자 랜덤번호 생성
		//파일명에 UUID를 붙여줌 => 550e8400-e29b-41d4-a716-446655440000_dog.jpg (앞코드는 예시)
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(savedPath, savedName);
		return uploadFileName;
	}
	/* 기능 : 업로드할 파일 경로를 알려주면 해당 파일 경로에 오늘 날짜에 해당 하는 년/월/일 폴더가 있는지 확인하여
	 * 		 없으면 폴더를 생성하고, 날짜 폴더 경로를 알려주는 메소드
	 * 매개변수 : uploadPath - 업로드할 파일의 경로
	 * 리턴타입 : 날짜 폴더 경로 => (예시) \\2021\\07\\14 , 구분자는 OS에 따라서 다름 \\//
	 * */
	private static String calcPath(String uploadPath) {
		//실행되는 시간을 기준으로 달력 정보를 가져옴
		Calendar cal = Calendar.getInstance();
		//File.separator는 OS에 따른 구분자를 말하는 것\\, /
		//\\2021
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		//\\2021\\07 (DecimalFormat은 월단위를 2자리로 맞춰줌)
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//\\2021\\07\\14
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
 
	}
	/* 기능 : 업로드경로, 폴더들이 주어지면 업로드 경로에 폴더들이 있는지 확인하고 없으면 해당 폴더들을 생성하는 메소드
	 * 매개변수 : uploadPath - 업로드경로 paths - 폴더들
	 * 리턴타입 : 없음
	 * */
	private static void makeDir(String uploadPath, String... paths){ //첫번째 String타입이 이후에도 있는데 갯수가 정해지지 않음
		//D:\\JAVA_mhw\\uploadfiles\\2021\\07\\14
		//년월일로 된 폴더가 이미 있으면 메소드를 종료
		if(new File(uploadPath+paths[paths.length-1]).exists())//new file새로운 객체만듬
			return;
		for(String path : paths) { //향상된 for문으로 싸악
			//D:\\JAVA_mhw\\uploadfiles\\2021\\07\\14
			File dirPath = new File(uploadPath + path);
			//파일(여기선 폴더)가 없으면 해당 폴더를 생성
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	/*기능 : 날짜 폴더 경로와 파일명이 주어지면 합쳐서 하나의 문자열로 반환하는 메소드,
	 * 		단, 경로에 \\대신 /로 가져옴
	 * */
	private static String makeIcon(String path, String fileName)
        	throws Exception{
		//\\2021\\07\\14 + \\ + 550e8400-e29b-41d4-a716-446655440000_dog.jpg
		//=>  \\2021\\07\\14\\550e8400-e29b-41d4-a716-446655440000_dog.jpg
		String iconName = path + File.separator + fileName;
		// /2021/07/14/550e8400-e29b-41d4-a716-446655440000_dog.jpg
		return iconName.replace(File.separatorChar, '/');
	}
}
