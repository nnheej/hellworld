package chap9;

public class Exercise9_3 {
	public static void main(String[] args){
		String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
		String path="";
		String fileName="";
		
		int lastIndex = fullPath.lastIndexOf('\\');
		path = fullPath.substring(0, lastIndex);
		fileName = fullPath.substring(lastIndex+1);
		
		System.out.println("fullpath: "+fullPath);
		System.out.println("path: "+path);
		System.out.println("filename: "+fileName);
	}
}
