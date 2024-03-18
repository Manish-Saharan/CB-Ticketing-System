package com.cb.ticketingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cb.ticketingSystem.model.Ticket;
import com.cb.ticketingSystem.TicketService;

@RestController
@RequestMapping()
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    
    @PostMapping("/purchaseTicket")
    public ResponseEntity<String> purchaseTicket(@RequestBody Ticket ticket){
        
        if (ticket.getFrom().isBlank() || ticket.getTo().isBlank() || ticket.getUser().getFirstName().isBlank() || ticket.getUser().getLastName().isBlank() || ticket.getUser().getEmail().isBlank() || ticket.getFrom().equals(ticket.getTo())){
            return ResponseEntity.badRequest().body("Ticket data is incomplete or invalid. Please provide all required fields.");
        } 
        return ResponseEntity.ok(ticketService.purchaseNewTicket(ticket));
    }
    
    @GetMapping("receipt/{id}")
    public String viewReceipt(@PathVariable String id){

        return ticketService.viewReceipt(id);
    }

    @GetMapping("ticketsBySection/{section}")
    public String viewTicketsBySection(@PathVariable String section){
        
        return ticketService.viewUserBySection(section);
    }

    @DeleteMapping("deleteTicket/{id}")
    public String deleteTicketById(@PathVariable String id){

        return ticketService.deleteUser(id);
    }

    @PutMapping("modifySeat/{id}")
    public String modifySeat(@PathVariable String id){

        return ticketService.modifyUserSeat(id);
    }

}
