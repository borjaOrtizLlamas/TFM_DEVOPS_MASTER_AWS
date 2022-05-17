package com.borja;	


import com.tfm.dto.Client;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import org.springframework.stereotype.Service;
//
//import software.amazon.awssdk.services.dynamodb.model.*;
//import software.amazon.awssdk.enhanced.dynamodb.*;
//import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
//import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
//import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

//@Service
public class AccesToDynamoDB {
	
//    Region region = Region.EU_WEST_1; 
//    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");
//    private final String tableName = "dababase-proyect";
//    DynamoDbClient ddb = DynamoDbClient.builder().credentialsProvider(EnvironmentVariableCredentialsProvider.create()).region(region).build();
//    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(getClient()).build();
//    DynamoDbTable<Client> clientsTable = enhancedClient.table(tableName, TableSchema.fromBean(Client.class));
//
//	public AccesToDynamoDB() {
//	}
//	
//    public boolean createClient(Client client) {
//    	try {
//    		if(clienteExiste(client)) {
//        		LOGGER.log(Level.INFO, "cliente existe");
//    			return false;
//    		}
//    		LOGGER.log(Level.CONFIG, "creando cliente " + client);
//    	    clientsTable.putItem(client);
//	    	return true;
//    	} catch (DynamoDbException e) {
//
//    		LOGGER.log(Level.SEVERE, e.getMessage());
//    		e.getStackTrace();     		
//	        throw e; 
//    	}
//    }
//	
//    
//    public boolean updateClient(Client client) {
//    	try {
//    		if(!clienteExiste(client)) {
//        		LOGGER.log(Level.INFO, "no existe cliente");
//    			return false;
//    		}
//    		LOGGER.log(Level.CONFIG, "actualizando cliente " + client);
//    	    clientsTable.putItem(client);
//    	    return true; 
//    	} catch (DynamoDbException e) {
//
//    		LOGGER.log(Level.SEVERE, e.getMessage());
//    		e.getStackTrace();     		
//	        throw e; 
//    	}
//    }
//    
//    public Client getClient(Client clientName) {
//        QueryConditional queryConditional = QueryConditional
//                .keyEqualTo(Key.builder()
//                .partitionValue(clientName.getName())
//                .build());
//        try {
//            Iterator<Client> results = clientsTable.query(r -> r.queryConditional(queryConditional)).items().iterator();
//            
//            while (results.hasNext()) {
//            	return results.next(); 	
//            }
//            return null; 
//    	} catch (DynamoDbException e) {
//    		LOGGER.log(Level.SEVERE, e.getMessage());
//    		e.getStackTrace();     		
//	        throw e; 
//    	}
//    }
//
//    public List<Client> getAllClient() {
//    	try {
//    		List<Client> clients = new ArrayList<Client>(); 
//            Iterator<Client> results = clientsTable.scan().items().iterator();
//            
//            while (results.hasNext()) {
//            	clients.add(results.next()); 
//            }
//    		
//    		return clients; 
//    		
//    	} catch (DynamoDbException e) {
//
//    		LOGGER.log(Level.SEVERE, e.getMessage());
//    		e.getStackTrace();     		
//	        throw e; 
//    	}
//    }
//
//    
//    public boolean deleteClient(Client client) {
//    	try {
//    		clientsTable.deleteItem(client); 
//    		return true; 
//    	} catch (DynamoDbException e) {
//    		LOGGER.log(Level.SEVERE, e.getMessage());
//    		e.getStackTrace();     		
//	        throw e; 
//    	}
//    }
//
//    
//    private boolean clienteExiste(Client cliente) {
//    	return getClient(cliente) != null; 
//    }
//    
//    
//    private DynamoDbClient getClient() {
//        return ddb;
//    }
    
}
