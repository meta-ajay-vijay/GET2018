/**
 * 
 */
package Dictionary;

/**
 * @author User1
 *
 */
public class BST implements Comparable<BST> {

	String keyString;
	String valueString;
	BST leftBST;
	BST rightBST;
	BST parent;

	/**
	 * Parameterized constructor
	 */
	public BST(String keyString, String valueString) {
		this.keyString = keyString;
		this.valueString = valueString;
	}

	/**
	 * @return the leftBST
	 */
	public BST getLeftBST() {
		return this.leftBST;
	}

	/**
	 * @param leftBST
	 *            the leftBST to set
	 */
	public void setLeftBST(BST leftBST) {
		this.leftBST = leftBST;
	}

	/**
	 * @return the rightBST
	 */
	public BST getRightBST() {
		return this.rightBST;
	}

	/**
	 * @param rightBST
	 *            the rightBST to set
	 */
	public void setRightBST(BST rightBST) {
		this.rightBST = rightBST;
	}

	/**
	 * @return the parent
	 */
	public BST getParent() {
		return this.parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(BST parent) {
		this.parent = parent;
	}

	/**
	 * @return the keyString
	 */
	public String getKeyString() {
		return keyString;
	}

	/**
	 * @param keyString
	 *            the keyString to set
	 */
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}

	/**
	 * @param valueString
	 *            the valueString to set
	 */
	public void setValueString(String valueString) {
		this.valueString = valueString;
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

	public String toString() {
		return "[ Word: " + this.getKeyString() + "\tMeaning: " + this.getValueString() + " ]\n";
	}

}
