/**
 * Function to create class queue
 */
class Queue {
	constructor() {
		this.elements = [];
	}
}

/**
 * Function to check if the array is empty
 */
Queue.prototype.isEmpty = function() {
	if (this.elements.length == 0) {
        return true; 
	}
	return false;
}

/**
 * Function to add the element in the queue
 */
Queue.prototype.enqueue = function(data) {
	this.elements.push(data);
}

/**
 * Function to remove the element from the queue
 */
Queue.prototype.dequeue = function() {
	if (this.isEmpty()) {
        return "Queue Underflow"; 
	}
    return this.elements.shift(); 
}

/**
 * Function to display the element
 */
Queue.prototype.display = function() {
    for (var i = 0; i < this.elements.length; i++) { 
        console.log(this.elements[i]); 
    }
}