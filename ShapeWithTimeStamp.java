/**
 * 
 */
package Basic;

import java.util.Date;

import Basic.ShapeInterface.ShapeType;
/**
 * @author User1
 *
 */
public class ShapeWithTimeStamp {
	Date date;
	ShapeInterface shape;
	ShapeType typeOfShape;
	
	public ShapeWithTimeStamp(ShapeType typeOfShape, ShapeInterface shape){
		this.shape = shape;
		this.typeOfShape = typeOfShape;
		date = new Date();
	}
	
	public ShapeInterface getShape(){
		return this.shape;
	}
	
	public ShapeType getShapeType(){
		return this.typeOfShape;
	}
	
	public Date getDate(){
		return this.date;
	}
	
}
