package Assignment8;

public class SparseMatrice {

	private int[][] sparseRepresentation;
	private int row, column;

	public SparseMatrice(int[][] toConvertIntoSparse) {
		try {
			int[][] copyOfOriginal = SparseMatrice.deepCopy(toConvertIntoSparse);
			if (SparseMatrice.isItSparse(copyOfOriginal)) {
				int[][] preSparseRepresentation = SparseMatrice.convertToSparse(copyOfOriginal);
				sparseRepresentation = preSparseRepresentation;
				this.row = copyOfOriginal.length;
				this.column = copyOfOriginal[0].length;
			} else {
				throw new Exception(
						"Matrice given in input is dense matrice\nSo can't be represented as sparse matrice.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public SparseMatrice(int[][] sparseMatrice, int row, int column) {
		int[][] copyOfSparseMatrice = SparseMatrice.deepCopy(sparseMatrice);
		sparseRepresentation = copyOfSparseMatrice;
		this.row = row;
		this.column = column;
	}

	public int[][] transposeOfSparse() {
		int[][] sparseMatrix = SparseMatrice.deepCopy(this.sparseRepresentation);
		for (int i = 0; i < sparseMatrix[0].length; i++) {
			int temporary = sparseMatrix[0][i];
			sparseMatrix[0][i] = sparseMatrix[1][i];
			sparseMatrix[1][i] = temporary;
		}
		int[][] transposeMatrix = SparseMatrice.deepCopy(sparseMatrix);
		transposeMatrix = SparseMatrice.sortSparse(transposeMatrix);
		return transposeMatrix;
	}

	public boolean isSymmetrical(){
		int[][] original = SparseMatrice.deepCopy(this.sparseRepresentation);
		int[][] transpose = this.transposeOfSparse();
		boolean reply = true;
		for(int i=0; i<transpose.length;i++){
			for(int j=0; j<transpose[0].length;j++){
				if(transpose[i][j] != original[i][j]){
					reply = false;
					break;
				}
			}
			if(!reply){
				break;
			}
		}
		return reply;
	}
	
	public static SparseMatrice addSparseMatrice(SparseMatrice matrice1, SparseMatrice matrice2)
	{
		int[][] firstMatrice = deepCopy(matrice1.sparseRepresentation);
		int[][] secondMatrice = deepCopy(matrice2.sparseRepresentation);
		
		int[][] resultMatrice;
		int size=0;
		
		for(int i=0;i<firstMatrice[0].length;i++)
		{
			for(int j=0;j<secondMatrice[0].length;j++)
			{
				if((firstMatrice[0][i]==secondMatrice[0][j]) && (firstMatrice[1][i]==secondMatrice[1][j])/*&& (firstMatrice[2][i]==secondMatrice[2][j])*/)
				{
					firstMatrice[2][i]= firstMatrice[2][i]+secondMatrice[2][j];
					secondMatrice[0][j]=-1;
					size++;
					
				}
			}
		}
		
		size = firstMatrice[0].length + secondMatrice[0].length - size;
		resultMatrice = new int [3][size];
		int i=0;
		for(int j=0;i<size && j<firstMatrice[0].length ;i++,j++)
		{
			resultMatrice[0][i]=firstMatrice[0][j];
			resultMatrice[1][i]=firstMatrice[1][j];
			resultMatrice[2][i]=firstMatrice[2][j];
		}
		for(int j=0;i<size && j<secondMatrice[0].length ;j++)
		{
			if(secondMatrice[0][j]!=-1)
			{
				resultMatrice[0][i]=secondMatrice[0][j];
				resultMatrice[1][i]=secondMatrice[1][j];
				resultMatrice[2][i]=secondMatrice[2][j];
				i++;
			}	
		}
		resultMatrice = SparseMatrice.sortSparse(resultMatrice);
		SparseMatrice objectToBeReturned = new SparseMatrice(resultMatrice,matrice1.row,matrice2.column);
		return objectToBeReturned;
	}
	
	
	public static SparseMatrice multiplySparseMatrice(SparseMatrice matrice1, SparseMatrice matrice2)
	{
		int[][] firstMatrice = deepCopy(matrice1.sparseRepresentation);
		int[][] secondMatrice = deepCopy(matrice2.sparseRepresentation);
		int size=firstMatrice[0].length + secondMatrice[0].length;
		int[][]	multiplyMatrice = new int[3][size];
		int result = 0;
		int k=0;
		boolean flag=false;
		try{
			if(matrice1.row == matrice2.column || matrice2.column==matrice1.row)
			{
				for(int i=0;i<firstMatrice[0].length && k<size;i++)
				{
					for(int j=0;j<secondMatrice[0].length;j++)
					{
						result = 0;
						if(firstMatrice[1][i]==secondMatrice[0][j])
						{
							result = firstMatrice[2][i] * secondMatrice[2][j];
								flag=false;
								for(int l=0;l<k;l++)
								{	
									if(multiplyMatrice[0][l]>firstMatrice[0][i])
									{
										break;
									}
									if(multiplyMatrice[0][l]==firstMatrice[0][i] && multiplyMatrice[1][l]==secondMatrice[1][j] )
									{
										multiplyMatrice[2][l]=multiplyMatrice[2][l]+result;
										flag=true;
										break;
									}
								}
								if(!flag)
								{
									multiplyMatrice[0][k] = firstMatrice[0][i];
									multiplyMatrice[1][k] = secondMatrice[1][j];
									multiplyMatrice[2][k] =	result;
									k++;
								}
								
							}
							
						}
					}
				}
			else
			{
				throw new Exception("Matrices Multiplication Condition Not Satisfied m x n");
			}
		}catch (Exception e)
		{
			System.out.println("The two matrice are not satisfying the m x n condition.");
		}
	 size = size - (size-k);
	 int sparseMatrice[][] = new int [3][size];
	 for(int i=0,m=0;i<size;i++)
	 {
		 if(multiplyMatrice[2][m]!=0)
		 {
			 sparseMatrice[0][i]= multiplyMatrice[0][m];
			 sparseMatrice[1][i]= multiplyMatrice[1][m];
			 sparseMatrice[2][i]= multiplyMatrice[2][m];
			 m++;
		 }
	 }
	 int maxRow=matrice1.row>matrice2.row?matrice1.row:matrice2.row;
	 int maxColumn=matrice1.column>matrice2.column?matrice1.column:matrice2.column;
	 SparseMatrice resultObject = new SparseMatrice(sparseMatrice,maxRow,maxColumn);
	 return resultObject;
	}
	
	
	private static int[][] sortSparse(int[][] toSort) {
		for (int i = 0; i < toSort[0].length; i++) {
			for (int j = i + 1; j < toSort[0].length; j++) {
				if (toSort[0][i] > toSort[0][j]) {
					int temporary = toSort[0][i];
					toSort[0][i] = toSort[0][j];
					toSort[0][j] = temporary;
					temporary = toSort[1][i];
					toSort[1][i] = toSort[1][j];
					toSort[1][j] = temporary;
					temporary = toSort[2][i];
					toSort[2][i] = toSort[2][j];
					toSort[2][j] = temporary;
				}
				else if(toSort[0][i] == toSort[0][j]) {
					if(toSort[1][i] > toSort[1][j]) {
						int temporary = toSort[1][i];
						toSort[1][i] = toSort[1][j];
						toSort[1][j] = temporary;
						temporary = toSort[2][i];
						toSort[2][i] = toSort[2][j];
						toSort[2][j] = temporary;
					}
				}
			}
		}
		int[][] sortedTranspose = SparseMatrice.deepCopy(toSort);
		return sortedTranspose;
	}

	private static boolean isItSparse(int[][] checkSparse) {
		boolean reply = false;
		int numberOfZeroes = 0;
		for (int i = 0; i < checkSparse.length; i++) {
			for (int j = 0; j < checkSparse[0].length; j++) {
				if (checkSparse[i][j] == 0) {
					numberOfZeroes++;
				}
			}
		}
		int totalElements = checkSparse.length * checkSparse[0].length;
		if (numberOfZeroes > totalElements / 2) {
			reply = true;
		}
		return reply;
	}

	private static int[][] convertToSparse(int[][] toConvert) {
		int numberOfZeros = 0;
		for (int i = 0; i < toConvert.length; i++) {
			for (int j = 0; j < toConvert[0].length; j++) {
				if (toConvert[i][j] == 0) {
					numberOfZeros++;
				}
			}
		}

		int columnInSparse = (toConvert.length * toConvert[0].length) - numberOfZeros;

		int[][] afterConversion = new int[3][columnInSparse];

		for (int i = 0, k = 0; i < toConvert.length; i++) {
			for (int j = 0; j < toConvert[0].length; j++) {
				if (toConvert[i][j] != 0) {
					if (k < afterConversion[0].length) {
						afterConversion[0][k] = i;
						afterConversion[1][k] = j;
						afterConversion[2][k] = toConvert[i][j];
						k++;
					}
				}
			}
		}

		return afterConversion;
	}

	private static int[][] deepCopy(int[][] toCopy) {
		int[][] toReturn = new int[toCopy.length][toCopy[0].length];
		for (int i = 0; i < toReturn.length; i++) {
			for (int j = 0; j < toReturn[0].length; j++) {
				toReturn[i][j] = toCopy[i][j];
			}
		}
		return toReturn;
	}

	public void displaySparseMatrice() {
		for (int i = 0; i < this.sparseRepresentation.length; i++) {
			for (int j = 0; j < this.sparseRepresentation[0].length; j++) {
				System.out.print(this.sparseRepresentation[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void displayMatrice(int[][] sparse) {
		for (int i = 0; i < sparse.length; i++) {
			for (int j = 0; j < sparse[0].length; j++) {
				System.out.print(sparse[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {

		SparseMatrice firstSparse = new SparseMatrice(new int[][] { { 0, 1, 0 }, { 0, 9, 2 }, { 3, 0, 0 } });
		SparseMatrice secondSparse = new SparseMatrice(new int[][] { {0,5,6},{0,8,0},{0,6,0} });
		if (!(firstSparse.sparseRepresentation == null)) {
			System.out.println("First Sparse matrix");
			firstSparse.displaySparseMatrice();

			int[][] transpose = firstSparse.transposeOfSparse();
			System.out.println("transpose of sparse matrix");
			SparseMatrice.displayMatrice(transpose);
			
			boolean symmetrical = firstSparse.isSymmetrical();
			if(symmetrical){
				System.out.println("\nSparse matrice is symmetrical.\n");
			}
			else{
				System.out.println("\nSparse matrice is not symmetrical.\n");
			}
			
			if (!(secondSparse.sparseRepresentation == null)) {
				System.out.println("Second Sparse matrix");
				secondSparse.displaySparseMatrice();
				
				SparseMatrice sumOfSparse = SparseMatrice.addSparseMatrice(firstSparse, secondSparse);
				System.out.println("\nSum of sparse matrices");
				sumOfSparse.displaySparseMatrice();
				
				SparseMatrice multiplicationOfSparse = SparseMatrice.multiplySparseMatrice(firstSparse, secondSparse);
				System.out.println("\nMultiplication of sparse matrices");
				multiplicationOfSparse.displaySparseMatrice();
				

				System.out.println("\nSecond Sparse matrix after operations");
				secondSparse.displaySparseMatrice();
				
			}
			
			System.out.println("\nFirst Sparse matrix after operations");
			firstSparse.displaySparseMatrice();
			
		}
	}
}