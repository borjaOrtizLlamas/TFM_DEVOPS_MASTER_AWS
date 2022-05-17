package com.borja;

//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//
//import com.tfm.dto.Client;
//
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * Hello world!
// *
// */
@RestController
@RequestMapping("/client")
public class App {

	
	@PostMapping
	@ResponseBody
	public String  createCliend() throws Exception {
		
		return "{\"hola\": \"mundo\"}"; 
	}
	
	
	
//
//	private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");
//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();
//
//	@Autowired
//	AccesToDynamoDB acces;
//
//	@PostMapping
//	@ResponseBody
//	public Boolean  createCliend(@RequestBody Client valueOne) throws Exception {
//		LOGGER.log(Level.INFO, "create clients");
//		return acces.createClient(valueOne); 
//	}
//
//	@GetMapping
//	@ResponseBody
//	public List<Client>  getClients() {
//		LOGGER.log(Level.INFO, "get  clients");
//		return acces.getAllClient();
//
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public Client getCliend(@PathVariable String id) throws Exception {
//		LOGGER.log(Level.INFO, "get client  --> " + id);
//		Client client = new Client();
//		client.setName(id);; 
//		return acces.getClient(client);
//	}
//	
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public boolean deleteCliend(@PathVariable String id) throws Exception {
//		Client client = new Client();
//		client.setName(id);; 
//		return acces.deleteClient(client);
//	}
//
//	@PutMapping
//	@ResponseBody
//	public Boolean editCliend(@RequestBody Client valueOne) throws Exception {
//		return acces.updateClient(valueOne); 
//	}
//
}
