package telran.util;

import java.util.HashMap;
import java.util.Map;

import telran.util.ConnectionList.ConnectionNode;
import telran.util.ConnectionsPool.Connection;

public class ConnectionsPoolImpl implements ConnectionsPool {
	ConnectionList connectionList = new ConnectionList();
	private Map<Integer, ConnectionNode> map = new HashMap<>();
	private int size;
	private int maxConnections;
	
	public ConnectionsPoolImpl(int poolSize) {
		maxConnections = poolSize;
	}
	
	public ConnectionsPoolImpl() {
		this(5);
	}
	
	@Override
	public boolean addConnection(Connection connection) {
		boolean res = false;
		ConnectionNode connectionInMap = map.get(connection.id);
		if (connectionInMap == null) {
			if (size == maxConnections) {
				deleteOldest();
			}
			connectionInMap = new ConnectionNode(connection);
			connectionList.addNode(connectionInMap);
			map.put(connection.id, connectionList.tail);
			res = true;
			size++;
		}
		return res;
	}

	@Override
	public Connection getConnection(int id) {
		ConnectionNode resNode = map.get(id);
		if (resNode != null) {
			connectionList.updateConnection(map.get(id));
		}
		return resNode == null ? null : resNode.obj;
	}

	private void deleteOldest() {
		int headId = connectionList.head.obj.id;
		connectionList.removeHead();
		map.remove(headId);
		size--;
	}
}
