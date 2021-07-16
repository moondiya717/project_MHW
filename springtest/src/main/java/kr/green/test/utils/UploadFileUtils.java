package kr.green.test.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils { //static클래스메소드라서 메소드쓸때 uploadFile. ~하고쓰면됨. 객체생성필요X
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);
		//uploadPath는 저장할폴더의위치까지 예를들면 D드라이브의 uploadfiles_test까지고 
		//savedPath는 파일이저장될위치로 2021/07/16 이런식으로 상세위치로 두갤 더하면 파일의 실제 구체적인 위치를 나타냄)
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(savedPath, savedName);
		return uploadFileName;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath,yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	private static void makeDir(String uploadPath, String... paths) {
		if(new File(paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			System.out.println(path);
			File dirPath = new File(uploadPath + path);
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	private static String makeIcon(String path, String fileName)
        	throws Exception{
		String iconName = path + File.separator + fileName;
		return iconName.replace(File.separatorChar, '/');
	}
}
