package com.club.cluborganization.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private String name;
    private String description;
    private String facultyIncharge;
    private LocalDate createdDate;

    public Club() {}

    // Getters and Setters
    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFacultyIncharge() { return facultyIncharge; }
    public void setFacultyIncharge(String facultyIncharge) { this.facultyIncharge = facultyIncharge; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }
}
