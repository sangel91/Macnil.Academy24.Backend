package macnil.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import macnil.academy.controller.dto.BroadcastDto;
import macnil.academy.mapper.BroadcastMapper;
import macnil.academy.model.Broadcast;
import macnil.academy.service.BroadcastService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/broadcasts")
public class BroadcastController {

    @Autowired
    BroadcastService broadcastService;

    @Autowired
    BroadcastMapper broadcastMapper;

    private Log logger = LogFactory.getLog(BroadcastController.class);
    
    @PostMapping
    public ResponseEntity<Broadcast> create(@Valid @RequestBody BroadcastDto broadcastDTO) {

        try {
            long startTime = System.currentTimeMillis();
            logger.info("Starting the broadcast create action.");
    
            Broadcast broadcast = broadcastMapper.broadcastDtoToBroadcast(broadcastDTO);
            Broadcast newBroadcast = broadcastService.create(broadcast);

            long endTime = System.currentTimeMillis();
            logger.info(String.format("Completed the broadcast create action in %d ms.", endTime - startTime));    
            
            return new ResponseEntity<>(newBroadcast, HttpStatus.CREATED);
        }
        catch(Throwable e) {
            logger.error("Something went wrong", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + e.getMessage(), e);
        }
        
    }

    @GetMapping
    public ResponseEntity<List<Broadcast>> readAll(@RequestParam(required = false) Integer number){
        try {
            long startTime = System.currentTimeMillis();
            logger.info("Starting the broadcast readAll action.");
    
            List<Broadcast> broadcasts = broadcastService.readAll(number);

            long endTime = System.currentTimeMillis();
            logger.info(String.format("Completed the broadcast readAll action in %d ms.", endTime - startTime));    
            
            return new ResponseEntity<>(broadcasts, HttpStatus.OK);
        }
        catch(Throwable e) {
            logger.error("Something went wrong", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + e.getMessage(), e);
        }
    }

    @GetMapping(value = "/{broadcastId}")
    public ResponseEntity<Broadcast> read(@PathVariable long broadcastId){

        try {
            long startTime = System.currentTimeMillis();
            logger.info("Starting the broadcast read action.");
    
            Broadcast broadcast = broadcastService.read(broadcastId);

            long endTime = System.currentTimeMillis();
            logger.info(String.format("Completed the broadcast read action in %d ms.", endTime - startTime));    
            
            return new ResponseEntity<>(broadcast, HttpStatus.OK);
        }
        catch(NoSuchElementException e) {
            String errMsg = String.format("No Broadcast with id %d", broadcastId);
            logger.error(errMsg, e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errMsg, e);
        }
        catch(Throwable e) {
            logger.error("Something went wrong", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + e.getMessage(), e);
        }
    }

    @PutMapping
    public ResponseEntity<Broadcast> update(@RequestBody Broadcast broadcast){         

        try {
            long startTime = System.currentTimeMillis();
            logger.info("Starting the broadcast update action.");
    
            Broadcast response = broadcastService.update(broadcast);

            long endTime = System.currentTimeMillis();
            logger.info(String.format("Completed the broadcast update action in %d ms.", endTime - startTime));    
            
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(NoSuchElementException nse) {
            String errMsg = String.format("No broadcast with id %d", broadcast.getId());
            logger.error(errMsg, nse);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errMsg, nse);
        }
        catch(Throwable e) {
            logger.error("Something went wrong", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + e.getMessage(), e);
        }
    }


    @DeleteMapping(value = "/{broadcastId}")
    public ResponseEntity<Void> delete(@PathVariable long broadcastId) {

        try {
            long startTime = System.currentTimeMillis();
            logger.info("Starting the broadcast delete action.");
    
            broadcastService.delete(broadcastId);

            long endTime = System.currentTimeMillis();
            logger.info(String.format("Completed the broadcast delete action in %d ms.", endTime - startTime));    
            
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        catch(NoSuchElementException nse) {
            String errMsg = String.format("No Broadcast with id %d", broadcastId);
            logger.error(errMsg, nse);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errMsg, nse);
        }
        catch(Throwable e) {
            logger.error("Something went wrong", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong: " + e.getMessage(), e);
        }
    }
    
}
