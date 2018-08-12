package CMD;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class VirtualCommandPrompt {

	private Directory currentDirectory;
	private Directory rootDir;
	
	/**
	 * Create Virtual Command Prompt with current directory as Root
	 */
	VirtualCommandPrompt(){
		Directory root = new Directory("root", null, "R:\\");
		this.rootDir = root;
		this.currentDirectory = this.rootDir;
	}
	
	/**
	 * Custom Exception for Virtual Command Prompt
	 *
	 */
	class VCPException extends Exception{
		VCPException(){
			super();
		}
	}
	
	/**
	 * Start the Virtual Command Prompt
	 * type 'exit' command for exit VCP(Virtual command prompt)
	 */
	public void start(){
		boolean run = true;
		while(run) {
			int len = 0;
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print(this.currentDirectory.getDirPath() + "> ");
				String tokens[] = sc.nextLine().split(" ");
				len = tokens[0].length();
				Command command = Command.valueOf(tokens[0]);
				switch(command) {
				case root:
					this.currentDirectory = this.rootDir;
					break;
				case mkdir:
					if(tokens.length == 1) {
						throw new VCPException();
					}
					this.makeDirectory(tokens);
					break;
				case ls:
					this.listOfDir();
					break;
				case cd:
					if(tokens.length == 1) {
						throw new VCPException();
					}
					this.changeDirectory(tokens);
					break;
				case bk:
					this.backDirectory();
					break;
				case tree:
					if(tokens.length > 2) {
						throw new VCPException();
					}
					this.dirStructure(tokens);
					break;
				case find:
					if(tokens.length != 2) {
						throw new VCPException();
					}
					this.showAllDir(this.currentDirectory, tokens[1]);
					break;
				case exit:
					System.out.println("VCP is closed !");
					run = false;
					break;
				default:
					break;
				}
			}catch(IllegalArgumentException e) {
				if(len != 0) {
					System.out.println("command does not exist");
				}
			}catch(VCPException e) {
				System.out.println("The syntax of the command is incorrect.");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Make new directory in current directory
	 * @param dirNames - List of new directories
	 */
	public void makeDirectory(String dirNames[]) {
		for(int i=1; i<dirNames.length; i++) {
			if(this.findDir(dirNames[i]) != null) {
				System.out.println("A subdirectory or file " + dirNames[i] + " already exists." );
			}
			else {
				Directory dir = new Directory(dirNames[i], this.currentDirectory,
						this.currentDirectory.getDirPath() + dirNames[i] + "\\");
				this.currentDirectory.addDirectory(dir);
			}
		}
	}
	
	/**
	 * Print list of subdirectory with their time of creation or add
	 */
	public void listOfDir() {
		try {
			if(this.currentDirectory.getSubDirList().size() == 0) {
				throw new VCPException();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS a");
			for(Directory dir: this.currentDirectory.getSubDirList()) {
				System.out.println(sdf.format(dir.getDirCreationTime())
						+ "  " + dir.getDirName());
			}
			System.out.println("       " + 
					this.currentDirectory.getSubDirList().size()+" Folder(s)");
		}catch(VCPException e) {
			System.out.println("No subfolders or files exist");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 * @param dirName - directory name to be found
	 * @return - Directory if it is found otherwise null
	 */
	public Directory findDir(String dirName) {
		for(Directory dir: this.currentDirectory.getSubDirList()) {
			if(dirName.equals(dir.getDirName())) {
				return dir;
			}
		}
		return null;
	}
	
	/**
	 * Change the current working directory to another directory
	 * @param tokens - String of commands
	 */
	public void changeDirectory(String tokens[]) {
		try {
			Directory dir = this.findDir(tokens[1]);
			if(tokens.length > 2 || dir==null) {
				throw new VCPException();
			}
			this.currentDirectory = dir;
		}catch(VCPException e) {
			System.out.println("The system cannot find the path specified.");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Back to parent directory
	 */
	public void backDirectory() {
		try {
			if(this.currentDirectory.equals(this.rootDir)) {
				throw new VCPException();
			}
			this.currentDirectory = this.currentDirectory.getParentDir();
		}catch(VCPException e) {
			System.out.print("");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Print all sub directory and their sub directory
	 * @param currentDir - Current directory
	 */
	public void printDirStructure(Directory currentDir, String horSpace, String verSpace) {
		for(Directory dir: currentDir.getSubDirList()) {
			System.out.print(verSpace);
			System.out.print(horSpace);
			System.out.println(dir.getDirName());
			
			this.printDirStructure(dir, horSpace,"     "+verSpace);
		}
	}

	/**
	 * Set directory for tree structure
	 * @param tokens - parameters with tree command
	 */
	public void dirStructure(String tokens[]) {
		try {
			if(tokens.length == 2) {
				Directory dir = this.findDir(tokens[1]);
				if(dir == null) {
					throw new VCPException();
				}
				this.printDirStructure(dir, "----", "|");
			}
			else {
				this.printDirStructure(this.currentDirectory, "----", "|");
			}
		}catch(VCPException e) {
			System.out.println("Invalid path! \n No subfolders exist.");
		}
	}
	
	/**
	 * Print all Directory that containing that name
	 * @param curDir -  current working directory
	 * @param dirName - name to be found
	 */
	public void showAllDir(Directory curDir, String dirName) {
		Pattern pattern = Pattern.compile("^" + dirName);
		for(Directory dir: curDir.getSubDirList()) {
			Matcher matcher = pattern.matcher(dir.getDirName());
			if(matcher.find()) {
				System.out.println("..\\" + dir.getParentDir().getDirName()+"\\"+dir.getDirName());
			}
			this.showAllDir(dir, dirName);
		}
	}
	
	public static void main(String[] args) {
		VirtualCommandPrompt vcdObject = new VirtualCommandPrompt();
		vcdObject.start();
	}
}





















