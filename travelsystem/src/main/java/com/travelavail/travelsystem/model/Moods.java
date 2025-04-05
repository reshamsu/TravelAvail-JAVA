package com.travelavail.travelsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "moods")
public class Moods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mood_id")
    private Long mood_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "mood_name")
    private MoodName moodName;

    private String destination;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Bookings booking;

    public enum MoodName {
        ADVENTURE, CHILL_RELAXATION, CULTURE_HISTORY, SOUL_ESCAPE
    }

    // Getters and Setters

    public Long getMood_id() {
        return mood_id;
    }

    public void setMood_id(Long mood_id) {
        this.mood_id = mood_id;
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName moodName) {
        this.moodName = moodName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }

}
