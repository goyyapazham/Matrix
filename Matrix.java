/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/

/* Nalanda Sharadjaya
   APCS1 pd9
   HW54 -- Red vs Blue
   2016-01-05
*/
import java.util.Arrays;
public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    } //O(1)

    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
    } //O(1)

    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    } //O(1)

    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    } //O(1)

    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return r >= 0 && r < size()
	    && c >= 0 && c < size()
	    && get(r, c) == null;
    } //O(1)

    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object oldVal = matrix[r][c]; //store old value
	matrix[r][c] = newVal; //set new value
	return oldVal; //return old value
    } //O(1)

    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retStr = "";
	for(int r = 0; r < size(); r++) {
	    for(int c = 0; c < size(); c++) {
		retStr += matrix[r][c] + "   ";
	    }
	    retStr += "\n";
	}
	return retStr;
    } //O(n^2)

    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	boolean retVal = false;
	if (this == rightSide) {
	    retVal = true;
	}
	else if (rightSide instanceof Matrix
	    && size() == ( (Matrix)rightSide).size() ) {
	    Matrix r = (Matrix) rightSide;
	    retVal = true;
	    for(int i = 0; i < size(); i++) {
		for(int j = 0; j < size(); j++) {
		    if (!isEmpty(i, j)
			&& (! get(i, j).equals(r.get(i, j)) ) ) {
			retVal = false;
			break;
		    }
		    else if( !(isEmpty(i, j)) && r.isEmpty(i, j)) {
			retVal = false;
			break;
		    }
		}
		break;
	    }
	}
	return retVal;
    } //O(n^2)

    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	//c1--; c2--;
	if(c1 >= 0 && c1 < size()
	   && c2 >= 0 && c2 < size()) {
	    for(int r = 0; r < size(); r++) {
		Object temp = matrix[r][c2];
		set(r, c2, matrix[r][c1]);
		set(r, c1, temp);
	    }
	}
	else System.out.println("input out of bounds...try again");
    } //O(n)

    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	//r1--; r2--;
	if(r1 >= 0 && r1 < size()
	   && r2 >= 0 && r2 < size()) {
	    for(int c = 0; c < size(); c++) {
		Object temp = matrix[r2][c];
		set(r2, c, matrix[r1][c]);
		set(r1, c, temp);
	    }
	}
	else System.out.println("input out of bounds...try again");
    } //O(n)

    //checks if the matrix is full
    public boolean isFull() {
	boolean retBln = true;
	for(int r = 0; r < size(); r++) {
	    for(int c = 0; c < size(); c++) {
		if ( get(r,c) == null ) {//if a value is found to be null will make retBln false and break loop
		    retBln = false;
		    break;
		}
	    }
	}
	return retBln;
    }//O(n^2)

    //return row r
    public Object[] getRow( int r ) {
	return matrix[r];
    }//O(1)

    //returns old row
    //sets row r to newRow
    public Object[] setRow( int r, Object[] newRow ) {
	Object[] oldRow = getRow(r);
	matrix[r] = newRow;
	return oldRow;
    }//O(1)
    
    //returns an object array with all values in column	r
    public Object[] getCol( int c ) {
	Object[] col = new Object[size()];
	for ( int r = 0; r < size(); r++ ) {
	    col[r] = get(r,c);
	}
	return col;
    }//O(n)

    //returns old col values;
    //sets col c values to newCol values;
    public Object[] setCol( int c, Object[] newCol ) {
	Object[] oldCol = getCol(c);
	for ( int r = 0; r < size(); r++ ) {
	    set(r,c,newCol[r]);
	}
	return oldCol;
    }
    
    //public void transpose()
    //public boolean contains( Object o )
    //main method for testing
    public static void main( String[] args ) {
	Matrix John = new Matrix();
	Matrix George = John;
	Matrix Paul = new Matrix(3);
	Matrix Ringo = new Matrix(4);

	/*
	System.out.println("Matrix John before populating...");
	System.out.print(John);
	System.out.println("1, 1 is empty: " + John.isEmpty(1, 1));
	*/
	for(int r = 0; r < John.size(); r++) {
	    for(int c = 0; c < John.size(); c++) {
	        John.set(r, c, (r + c) % 2);
	    }
	}
	/*
	System.out.println();
	
	System.out.println("Matrix John after populating...");
	System.out.print(John);
	System.out.println("1, 1 is empty: " + John.isEmpty(1, 1));

	System.out.println();
	
	System.out.println("Matrix George after populating...");
	System.out.print(George);

	System.out.println();
	*/
	Matrix Nala = new Matrix();
	for(int r = 0; r < Nala.size(); r++) {
	    for(int c = 0; c < Nala.size(); c++) {
		Nala.set(r, c, John.get(r, c));
	    }
	}
	/*
	System.out.println("Matrix Nala after populating...");
	System.out.println(Nala);

	System.out.println("John = George?");
	System.out.println(John.equals(George));

	System.out.println("John = Nala?");
	System.out.println(John.equals(Nala));

	System.out.println("George = Nala?");
	System.out.println(George.equals(Nala));

	System.out.println();
	*/
	for(int r = 0; r < Paul.size(); r++) {
	    for(int c = 0; c < Paul.size(); c++) {
		Paul.set(r, c, (int)(Math.random() * 4) + 1);
	    }
	}
	/*
	System.out.println("Matrix Paul after populating...");
	System.out.print(Paul);
	System.out.println("swap rows 1 and 3...");
	Paul.swapRows(1, 3);
	System.out.println(Paul);
	System.out.println("swap rows 0 and 4...");
	Paul.swapRows(0, 4);
	System.out.println(Paul);
	System.out.println("swap rows 2 and 2...");
	Paul.swapRows(2, 2);
	System.out.println(Paul);
	System.out.println("swap rows 3 and 2...");
	Paul.swapRows(3, 2);
	System.out.println(Paul);

	System.out.println();
	*/
	for(int r = 0; r < Ringo.size(); r++) {
	    for(int c = 0; c < Ringo.size(); c++) {
		Ringo.set(r, c, (int)(Math.random() * 4) + 1);
	    }
	}
	/*
	System.out.println("Matrix Ringo after populating...");
	System.out.print(Ringo);
	System.out.println("swap columns 1 and 3...");
	Ringo.swapColumns(1, 3);
	System.out.println(Ringo);
	System.out.println("swap columns 0 and 4...");
	Ringo.swapColumns(0, 4);
	System.out.println(Ringo);
	System.out.println("swap columns 2 and 2...");
	Ringo.swapColumns(2, 2);
	System.out.println(Ringo);
	System.out.println("swap columns 3 and 2...");
	Ringo.swapColumns(3, 2);
	System.out.println(Ringo);

	System.out.println();

	System.out.println("Paul = Ringo?");
	System.out.println(Paul.equals(Ringo));
	*/

	System.out.println("Matrix John...");
	System.out.println(John);
	System.out.println("Matrix George...");
	System.out.println(George);
	System.out.println("Matrix Paul...");
	System.out.println(Paul);
	System.out.println("Matrix Ringo...");
	System.out.println(Ringo);
	System.out.println("Matrix Nala...");
	System.out.println(Nala);
	System.out.println( Nala.isFull() );

	Nala.set(1,1,null);
	System.out.println("Matrix Nala...");
	System.out.println(Nala);
	System.out.println( Nala.isFull() );
	System.out.println("Matrix Nala row 1...");
	System.out.println( Arrays.toString(Nala.getRow(1)) );

	Object[] newRow = new Object[2];
	newRow[0] = 1;
	newRow[1] = 4;
	Nala.setRow(1,newRow);
	System.out.println("Matrix Nala changed row 1...");
	System.out.println(Nala);
	
	System.out.println("Matrix John...");
	System.out.println(John);
	System.out.println("Matrix John column 1...");
	System.out.println( Arrays.toString(John.getCol(1)) );

	Object[] newCol = new Object[2];
	newCol[0] = 1;
	newCol[1] = 4;
	John.setCol(1,newCol);
	System.out.println("Matrix John changed column 1...");
	System.out.println(John);
	
    }

}//end class Matrix
