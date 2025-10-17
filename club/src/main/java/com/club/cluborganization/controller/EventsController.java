package com.club.cluborganization.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.cluborganization.model.Event;
import com.club.cluborganization.repository.EventsRepository;

@RestController
@RequestMapping("/events")
public class EventsController {

    private final EventsRepository eventsRepository;

    public EventsController(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Event  createEvent(@RequestBody Event event) {
        return eventsRepository.save(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event details) {
        Event event = eventsRepository.findById(id).orElse(null);
        if (event != null) {
            event.setEventName(details.getEventName());
            event.setDescription(details.getDescription());
            event.setEventDate(details.getEventDate());
            event.setLocation(details.getLocation());
            event.setStatus(details.getStatus());
            event.setClub(details.getClub());
            return eventsRepository.save(event);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventsRepository.deleteById(id);
    }
}
