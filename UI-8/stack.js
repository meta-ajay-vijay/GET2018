/**
 * Function to create class stack
 */
class Stack {
	constructor() {
		this.elements = [];
	}
}

/**
 * Function to check if the array is empty
 */
Stack.prototype.isEmpty = function() {
	if (this.elements.length == 0) {
        return true; 
	}
	return false;
}

/**
 * Function to add the element in the stack
 */
Stack.prototype.pushElement = function(data) {
	this.elements.push(data);
}

/**
 * Function to remove the element from the stack
 */
Stack.prototype.popElement = function() {
	if (this.isEmpty()) {
        return "Stack Underflow"; 
	}
    return this.elements.pop(); 
}

/**
 * Function to display the element
 */
Stack.prototype.display = function() {
    for (var i = 0; i < this.elements.length; i++) { 
        console.log(this.elements[i]); 
    }
}