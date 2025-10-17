package com.club.cluborganization.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club; // ✅ matches Club.clubId (Long)

    private String eventName;
    private String description;
    private LocalDate eventDate;
    private String location;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    public Event() {}

    public enum EventStatus {
        UPCOMING,
        COMPLETED,
        CANCELLED
    }

    // Getters and Setters
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public EventStatus getStatus() { return status; }
    public void setStatus(EventStatus status) { this.status = status; }
}
