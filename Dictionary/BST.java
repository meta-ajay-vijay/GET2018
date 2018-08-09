/**
 * 
 */
package Dictionary;

/**
 * @author User1
 *
 */
public class BST implements Comparable<BST>{

	String keyString;
	String valueString;
	BST leftBST;
	BST rightBST;
	
	/**
	 * Parameterized constructor 
	 */
	public BST(String keyString, String valueString) {
		this.keyString = keyString;
		this.valueString = valueString;
		this.leftBST = null;
		this.rightBST = null;
	}

	/**
	 * @return the leftBST
	 */
	public BST getLeftBST() {
		return leftBST;
	}

	/**
	 * @param leftBST the leftBST to set
	 */
	public void setLeftBST(BST leftBST) {
		this.leftBST = leftBST;
	}

	/**
	 * @return the rightBST
	 */
	public BST getRightBST() {
		return rightBST;
	}

	/**
	 * @param rightBST the rightBST to set
	 */
	public void setRightBST(BST rightBST) {
		this.rightBST = rightBST;
	}

	/**
	 * @return the keyString
	 */
	public String getKeyString() {
		return keyString;
	}

	/**
	 * @return the valueString
	 */
	public String getValueString() {
		return valueString;
	}

	@Override
	public int compareTo(BST secondBST) {
		return this.getKeyString().compareToIgnoreCase(secondBST.getKeyString());
	}
	
	

}
