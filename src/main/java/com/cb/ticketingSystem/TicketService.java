package com.cb.ticketingSystem;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.cb.ticketingSystem.model.Ticket;
import com.cb.ticketingSystem.model.Receipt;

@Service
public class TicketService {
    private HashMap<String, Receipt> receiptsA = new HashMap();
	private HashMap<String, Receipt> receiptsB = new HashMap();
    
    int countA=1;
    int countB=1;
    
    public String purchaseNewTicket(Ticket ticket) {
        
        String section="A";    
        String ticketId;
        if (receiptsB.size() < receiptsA.size()){
            section="B";
            ticketId = section + (countB);
            countB++;
        }
        else{
            ticketId = section + (countA);
            countA++;
        }
       
        int price;
        if ("W".equals(ticket.getFrom()) && "X".equals(ticket.getTo())){
            price=100;}
        else if ("W".equals(ticket.getFrom()) && "Y".equals(ticket.getTo())){
            price=120;}    
        else if ("W".equals(ticket.getFrom()) && "Z".equals(ticket.getTo())){
            price=150;}
        else if ("W".equals(ticket.getFrom()) && "Y".equals(ticket.getTo())){
            price=170;}
        else{
            price=80;}

        Receipt receipt = new Receipt(ticketId, ticket.getFrom(), ticket.getTo(), ticket.getUser(), price, section);
        if (section.equals("A")){
            receiptsA.put(ticketId, receipt);
        }
        else{
            receiptsB.put(ticketId, receipt);
        }
        return "Your ticket is booked successfully." + receipt.toString();
    }

    public String viewReceipt(String ticketId){
        if ((ticketId.charAt(0))=='B'){
            Receipt receipt=receiptsB.get(ticketId);
            if (receipt==null){
                return "Receipt not found for ticket ID: " + ticketId;
            }
            return receipt.toString();
        }
        else if ((ticketId.charAt(0))=='A'){
            Receipt receipt=receiptsA.get(ticketId);
            if (receipt==null){
                return "Receipt not found for ticket ID: " + ticketId;
            }
            return receipt.toString();
        }
        else{
            return "Invalid Ticket ID format. Ticket ID start with 'A' or 'B' followed by a number.";
        }
    }

    public String viewUserBySection(String section){
        if ("A".equals(section)){
            return receiptsA.toString();
        }
        else if ("B".equals(section)) {
            return receiptsB.toString();
        }
        else{
            return "Entered section is invalid. Only accepted inputs are: 'A' and 'B'";
        }
    }

    public String deleteUser(String ticketId){
        if ((ticketId.charAt(0))=='B'){
            if (receiptsB.containsKey(ticketId)){
            receiptsB.remove(ticketId);
            return "Ticket " + ticketId + " deleted successfully.";
            }
            else{
                return "Entered Ticket ID do not exist in section B.";
            }
        }
        else if ((ticketId.charAt(0))=='A') {
            if (receiptsA.containsKey(ticketId)){
                receiptsA.remove(ticketId);
                return "Ticket " + ticketId + " deleted successfully.";
                }
                else{
                    return "Entered Ticket ID do not exist in section A.";
                }
        }
        else{
            return "Invalid Ticket ID format. Ticket ID start with 'A' or 'B' followed by a number.";
        }
    }

    public String modifyUserSeat(String ticketId){
        if ((ticketId.charAt(0))=='B'){
            Receipt receipt=receiptsB.get(ticketId);
            if (receipt==null){
                return "This ticket ID: " + ticketId + " do not exist in section B.";
            }
            receipt.setSection("A");
            receipt.setTicketId("A" + countA);
            receiptsA.put("A" + countA, receipt);
            countA++;
            deleteUser(ticketId);
            return "You new seat has been allocated in section A. " + receipt.toString();
        }
        else if ((ticketId.charAt(0))=='A'){
            Receipt receipt=receiptsA.get(ticketId);
            if (receipt==null){
                return "This ticket ID: " + ticketId + " do not exist in section A.";
            }
            receipt.setSection("B");
            receipt.setTicketId("B" + countB);
            receiptsB.put("B" + countB, receipt);
            countB++;
            deleteUser(ticketId);
            return "You new seat has been allocated in section B. " + receipt.toString();
        }
        else{
            return "Invalid Ticket ID format. Ticket ID start with 'A' or 'B' followed by a number.";
        }
    }
}
