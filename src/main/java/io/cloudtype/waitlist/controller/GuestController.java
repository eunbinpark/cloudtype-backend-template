package io.cloudtype.waitlist.controller;

import io.cloudtype.waitlist.exception.ResourceNotFoundException;
import io.cloudtype.waitlist.model.Drug;
import io.cloudtype.waitlist.model.Guest;
import io.cloudtype.waitlist.repository.DrugRepository;
import io.cloudtype.waitlist.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;
    private DrugRepository drugRepository;

    @GetMapping("/drug")
    public ResponseEntity<Drug> searchDrugs(@RequestParam String tki, @RequestParam String drug) {
        Drug drugA = drugRepository.searchDrug(tki, drug);
        return ResponseEntity.ok(drugA);
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest guest  = guestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guest not found."));
        return ResponseEntity.ok(guest);
    }

    @PutMapping("{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guestInfo) {
        Guest updateGuest = guestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guest not found."));
        updateGuest.setName(guestInfo.getName());
        updateGuest.setNum(guestInfo.getNum());
        updateGuest.setPhoneNum(guestInfo.getPhoneNum());

        guestRepository.save(updateGuest);

        return ResponseEntity.ok(updateGuest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteGuest(@PathVariable Long id) {

        Guest guest = guestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guest not found."));

        guestRepository.delete(guest);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
