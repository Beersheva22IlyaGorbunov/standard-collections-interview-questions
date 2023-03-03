package telran.util;

import telran.util.ConnectionsPool.Connection;

public class ConnectionList {
	int size = 0;

	static class ConnectionNode {
		Connection obj;
		ConnectionNode prev;
		ConnectionNode next;
		ConnectionNode(Connection obj) {
			this.obj = obj;
		}
	}
	ConnectionNode head;
	ConnectionNode tail;
	
	
	
	void updateConnection(ConnectionNode connectionInMap) {
		if (connectionInMap != tail) {
			removeNotTailNode(connectionInMap);
			addNode(connectionInMap);
		}
	}


	void addNode(ConnectionNode newTail) {
		if (head == null) {
			head = tail = newTail;
		} else {
			tail.next = newTail;
			newTail.prev = tail;
			tail = newTail;
		}
		size++;
	}
	
	private void removeNotTailNode(ConnectionNode current) {
		if (current == head) {
			removeHead();
		} else {
			removeMiddleElement(current);
		}
		size--;
	}
	
	void removeHead() {
		if (size == 1) {
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
	}

	private void removeMiddleElement(ConnectionNode node) {
		ConnectionNode prevNode = node.prev;
		ConnectionNode nextNode = node.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	

}
