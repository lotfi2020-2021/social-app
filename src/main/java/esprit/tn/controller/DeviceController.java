package esprit.tn.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import esprit.tn.entity.Device;
import esprit.tn.entity.User;
import esprit.tn.repository.DeviceRepository;
import esprit.tn.service.UserService;




@RequestMapping("/api/v1")

@RestController

public class DeviceController {
	@Autowired
	private  UserService userService;
	
	 @Autowired
	  DeviceRepository deviceRepository;
	  @GetMapping("/Devices")
	  public ResponseEntity<List<Device>> getAllTutorials(@RequestParam(required = false) String name) {
	    try {
	      List<Device> devices = new ArrayList<Device>();
	      if (name == null)
	    	  deviceRepository.findAll().forEach(devices::add);
	      else
	    	  deviceRepository.findByname(name).forEach(devices::add);
	      if (devices.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(devices, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  

	 
	    
	  
	  @GetMapping("/Devices/{id}")
	  public ResponseEntity<Device> getTutorialById(@PathVariable("id") long id) {
	    Optional<Device> tutorialData = deviceRepository.findById(id);
	    if (tutorialData.isPresent()) {
	      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/Devices")
	  public ResponseEntity<Device> createTutorial(@RequestBody Device device) {
	    try {
	    	
	    	 final LocalDateTime date = LocalDateTime.now();
	    	
	    	
	    	
	      Device _device = new Device();
	       _device.setName(device.getName())   ;        
	       _device.setDescription(device.getDescription()) ;
	       _device.setTelephone( device.getTelephone())	;	 
	       _device.setDate_exp( device.getDate_exp());		 
	       _device.setCreatedAt(date) ;		 
	       _device.setSerie( device.getSerie());
	        _device.setCode_postal( device.getCode_postal());		 
	        _device.setType(device.getType())	;  
	        _device.setAdresse(  device.getAdresse())	;
	        _device.setVille(device.getVille())	;  
	          
	      
	      deviceRepository.save(_device);
	      return new ResponseEntity<>(_device, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @PutMapping("/Devices/{id}")
	  public ResponseEntity<Device> updateTutorial(@PathVariable("id") long id, @RequestBody Device device) {
	    Optional<Device> deviceData = deviceRepository.findById(id);
	    if (deviceData.isPresent()) {
	    	 final LocalDateTime date = LocalDateTime.now();
	      Device _device = deviceData.get();
	      _device.setName(device.getName())   ;        
	       _device.setDescription(device.getDescription()) ;
	       _device.setTelephone( device.getTelephone())	;	 
	       _device.setDate_exp( device.getDate_exp());		 
	       _device.setUpdatedAt(date);		 
	       _device.setSerie(device.getSerie());
	        _device.setCode_postal( device.getCode_postal());		 
	        _device.setType(device.getType())	;  
	        _device.setAdresse(  device.getAdresse())	;
	        _device.setVille(device.getVille())	;  
	      return new ResponseEntity<>(deviceRepository.save(_device), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/Devices/{id}")
	  public ResponseEntity<HttpStatus> deleteDevice(@PathVariable("id") long id) {
	    try {
	    	deviceRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @DeleteMapping("/Devices")
	  public ResponseEntity<HttpStatus> deleteAllDevices() {
	    try {
	    	deviceRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  @GetMapping("/Devices/Type")
	  public ResponseEntity<List<Device>> findByType(String adresse ) {
	    try {
	      List<Device> devices = deviceRepository.findByadresse( adresse);
	      if (devices.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(devices, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	

}
