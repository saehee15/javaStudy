public class subString {

	public static void main(String[] args) {
		String fullPath = "c;\\jdk1.8\\word\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		int pos = fullPath.lastIndexOf("\\");
	
		if(pos!=-1) {
			path = fullPath.substring(0, pos);
			fileName = fullPath.substring(+1);
		}
		
		System.out.println("fullpath"+fullPath);
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);

	}

}
