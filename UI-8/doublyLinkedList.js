/**
 *Function to create node
 */
function Node(data) {
    this.data = data;
    this.next = null;
    this.previous = null;
}

/**
*Function to create the Link List
*/
function LinkedList() {
    this.head = null;

    /**
     * Function to check if the list is empty
     */
    this.isEmpty = function() {
        if(this.head == null) {
            return true;
        }
        return false;
    }

    /**
     * Function to add the data to the list
     */
    this.add = function(data) {
        var node = new Node(data);
        var current; 
        if (this.head == null) 
            this.head = node; 
        else { 
            current = this.head; 
            while (current.next) { 
                current = current.next; 
            }  
            current.next = node;
            node.previous = current; 
        }  
    }

    /**
     * Function to remove the data from the list
     */
    this.remove = function(data) { 
        if(!this.isEmpty()) {
            var current = this.head; 
            var previousElement = null; 
            while (current != null) {  
                if (current.data === data) { 
                    if (previousElement == null) { 
                        this.head = current.next; 
                        if(current.next!=null) {
                            current.next.previous = this.head;
                        }
                    } else { 
                        previousElement.next = current.next; 
                        if(current.next!=null) {
                            current.next.previous = previousElement;
                        }
                    } 
                    return current.data; 
                } 
                previousElement = current; 
                current = current.next; 
            } 
        }
            return -1;
    }

    /**
     * Function to dsplay the data
     */
    this.display = function(list) {
        if(!this.isEmpty()){
            var currentNode = this.head;
            var output = "";
            while (currentNode != null) {
                output += currentNode.data + "\n";
                currentNode = currentNode.next;
            }
            console.log(output);
        } else {
            console.log("List is empty");
        }
    }
}