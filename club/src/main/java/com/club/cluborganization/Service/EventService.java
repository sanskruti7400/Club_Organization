package com.club.cluborganization.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.club.cluborganization.model.Event;
import com.club.cluborganization.repository.EventsRepository;

@Service
public class EventService {

    private final EventsRepository eventsRepository;

    public EventService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventsRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        return eventsRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }
}
