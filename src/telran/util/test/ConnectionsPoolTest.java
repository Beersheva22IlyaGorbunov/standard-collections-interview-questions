package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.ConnectionsPool;
import telran.util.ConnectionsPool.Connection;
import telran.util.ConnectionsPoolImpl;

class ConnectionsPoolTest {
	ConnectionsPool pool;
	@BeforeEach
	void setUp() throws Exception {
		pool = new ConnectionsPoolImpl();
	} 

	@Test
	void connectionsPoolAddTest() {
		 assertTrue(pool.addConnection(new Connection(1, "123123", 2304)));
		 assertTrue(pool.addConnection(new Connection(2, "1231233", 2304)));
		 assertTrue(pool.addConnection(new Connection(3, "1231233", 2304)));
		 assertTrue(pool.addConnection(new Connection(4, "1231233", 2304)));
		 assertTrue(pool.addConnection(new Connection(5, "1231233", 2304)));
		 assertFalse(pool.addConnection(new Connection(1, "123123", 2304)));
		 assertTrue(pool.addConnection(new Connection(8, "123123", 2304)));
		 assertNull(pool.getConnection(1));
	}

}
