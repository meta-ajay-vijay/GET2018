package CMD;

import java.util.Date;
import java.util.List;
import java.util.LinkedList;

public class Directory {

	private String dirName;
	private Date dirCreationTime;
	private Directory parentDirectory;
	private String dirPath;
	private List<Directory> subDirectory;
	
	/**
	 * Create Directory
	 * @param dirName - Directory Name 
	 */
	Directory(String dirName, Directory parentDir, String dirPath){
		this.dirName = dirName;
		this.dirCreationTime = new Date();
		this.parentDirectory = parentDir;
		this.dirPath = dirPath;
		this.subDirectory = new LinkedList<Directory>();
	}
	
	/**
	 * Add directory to current directory
	 * @param dir - directory to be add
	 */
	public void addDirectory(Directory dir) {
		this.subDirectory.add(dir);
	}
	
	/**
	 * 
	 * @return - Name of the directory
	 */
	public String getDirName() {
		return this.dirName;
	}
	
	/**
	 * 
	 * @return - Directory creation time
	 */
	public Date getDirCreationTime() {
		return this.dirCreationTime;
	}
	
	/**
	 * 
	 * @return - Parent directory of current directory
	 */
	public Directory getParentDir() {
		return this.parentDirectory;
	}
	
	/**
	 * 
	 * @return - Directory path
	 */
	public String getDirPath() {
		return this.dirPath;
	}
	
	/**
	 * 
	 * @return - List of Sub directory of current directory 
	 */
	public List<Directory> getSubDirList(){
		return this.subDirectory;
	}
}
