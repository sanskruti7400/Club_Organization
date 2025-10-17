package com.club.cluborganization.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    private LocalDateTime timestamp;

    public Attendance() {}

    public enum AttendanceStatus {
        PRESENT,
        ABSENT
    }

    // Getters and Setters
    public Long getAttendanceId() { return attendanceId; }
    public void setAttendanceId(Long attendanceId) { this.attendanceId = attendanceId; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    public AttendanceStatus getStatus() { return status; }
    public void setStatus(AttendanceStatus status) { this.status = status; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
